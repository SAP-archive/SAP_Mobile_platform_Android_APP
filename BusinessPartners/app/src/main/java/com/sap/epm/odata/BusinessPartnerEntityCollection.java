package com.sap.epm.odata;

import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.epm.mbo.BusinessPartner;
import com.sap.smp.client.odata.ODataEntity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by i821448 on 15-07-03.
 *
 */
public class BusinessPartnerEntityCollection  {
    private static final String TAG = BusinessPartner.class.getSimpleName();

    public static final String COLLECTION = "BusinessPartners";
    public static final String BUSINESS_PARTNER_CREATE_TAG = "BusinessPartnersCreate";
    public static final String BUSINESS_PARTNER_READ_TAG = "BusinessPartnersRead";



    private static BusinessPartnerEntityCollection instance = null;


    private Map<String, BusinessPartner> businessPartnerCache;
    private UIListener uiListener;


    protected BusinessPartnerEntityCollection(UIListener uiListener) {
        this.uiListener = uiListener;
    }

    public static BusinessPartnerEntityCollection getInstance(UIListener uiListener) {
        if(instance == null) {
            instance = new BusinessPartnerEntityCollection(uiListener);
        }
        return instance;
    }

    public void findAll(OfflineRequestListener requestListener)
            throws OfflineGenericException {
        Log.d(TAG, "findAll");
        EntityCollection.sendGETRequest(COLLECTION, BUSINESS_PARTNER_READ_TAG, requestListener);
    }

    public void create(BusinessPartner businesPartner, OfflineRequestListener requestListener)
            throws OfflineGenericException {

        if (EntityCollection.isOfflineStoreOpen()) {
            EntityCollection.sendPOSTRequest(businesPartner.getEntity(), COLLECTION, requestListener);
        }

    }

    public void flush(OfflineFlushListener flushListener) throws OfflineGenericException {
        EntityCollection.sendFlush(flushListener);
    }

    public void refresh(OfflineRefreshListener refreshListener) throws OfflineGenericException {
        EntityCollection.sendRefresh(refreshListener);
    }

    public  ArrayList<BusinessPartner> getBusinessPartners(){
        Log.d(TAG, "getBusinessPartners");
        ArrayList<BusinessPartner> bussPartners;
        if (businessPartnerCache!=null){
            bussPartners = new ArrayList<>(businessPartnerCache.values());
        } else {
            bussPartners = new ArrayList<>();
        }
        Log.d(TAG, "There are " + bussPartners.size() + " business partners");
        return bussPartners;
    }


    public void setBusinessPartners(List<ODataEntity> entities){
        businessPartnerCache = new HashMap<>();
        for (ODataEntity entity: entities) {
            BusinessPartner bp = new BusinessPartner(entity);
            businessPartnerCache.put(bp.getBP_ID(),bp);
        }
    }


}
