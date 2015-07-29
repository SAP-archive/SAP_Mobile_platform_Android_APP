package com.sap.epm.odata;

import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.epm.mbo.SalesOrder;
import com.sap.smp.client.odata.ODataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by i821448 on 15-07-03.
 *
 */
public class SalesOrderEntityCollection  {

    private static final String TAG = SalesOrderEntityCollection.class.getSimpleName();

    public static final String COLLECTION = "SalesOrders";
    public static final String SALES_ORDER_TAG = "SalesOrders";

    private static SalesOrderEntityCollection instance = null;


    private static Map<String,SalesOrder> salesOrderCache;


    protected SalesOrderEntityCollection() {

    }

    public static SalesOrderEntityCollection getInstance() {
        if(instance == null) {
            instance = new SalesOrderEntityCollection();
        }
        return instance;
    }

    public void findAll(String fkId, OfflineRequestListener requestListener)
            throws OfflineGenericException {
        Log.d(TAG, "findAll");
        EntityCollection.sendGETRequest(BusinessPartnerEntityCollection.COLLECTION + "('" + fkId + "')/" + COLLECTION,
                SALES_ORDER_TAG, requestListener);
    }

    public ArrayList<SalesOrder> getSalesOrders(){
        Log.d(TAG, "getSalesOrders");
        ArrayList<SalesOrder> salesOrders;
        if (salesOrderCache!=null){
            salesOrders = new ArrayList<>(salesOrderCache.values());
        } else {
            salesOrders = new ArrayList<>();
        }
        Log.d(TAG, "There are " + salesOrders.size() + " Sales Orders");
        return salesOrders;
    }


    public void setSalesOrders(List<ODataEntity> entities){
        Log.d(TAG, "setSalesOrders");
        salesOrderCache = new HashMap<>();
        for (ODataEntity entity: entities) {
            SalesOrder so = new SalesOrder(entity);
            salesOrderCache.put(so.getSO_ID(),so);
        }
    }


}
