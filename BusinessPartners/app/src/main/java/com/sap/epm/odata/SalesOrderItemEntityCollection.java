package com.sap.epm.odata;

import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.epm.mbo.BusinessPartner;
import com.sap.epm.mbo.SalesOrder;
import com.sap.epm.mbo.SalesOrderItems;
import com.sap.smp.client.odata.ODataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by i821448 on 15-07-03.
 *
 */
public class SalesOrderItemEntityCollection {

    private static final String TAG = SalesOrderItemEntityCollection.class.getSimpleName();

    public static final String COLLECTION = "Items";
    public static final String SALES_ORDER_ITEMS_TAG = "Items";

    private static SalesOrderItemEntityCollection instance = null;


    private static Map<String,SalesOrderItems> salesOrderItemsCache;


    protected SalesOrderItemEntityCollection() {
    }

    public static SalesOrderItemEntityCollection getInstance() {
        if(instance == null) {
            instance = new SalesOrderItemEntityCollection();
        }
        return instance;
    }

    public void findAll(String fkId, OfflineRequestListener requestListener)
            throws OfflineGenericException {
        Log.d(TAG, "findAll");
        EntityCollection.sendGETRequest(SalesOrderEntityCollection.COLLECTION + "('" + fkId + "')/" + COLLECTION, SALES_ORDER_ITEMS_TAG, requestListener);
    }

    public ArrayList<SalesOrderItems> getSalesOrderItems(){
        Log.d(TAG, "getSalesOrders");
        ArrayList<SalesOrderItems> soItems;
        if (salesOrderItemsCache!=null){
            soItems = new ArrayList<>(salesOrderItemsCache.values());
        } else {
            soItems = new ArrayList<>();
        }
        Log.d(TAG, "There are " + soItems.size() + " Sales Orders");
        return soItems;
    }


    public void setSalesOrderItems(List<ODataEntity> entities){
        Log.d(TAG, "setSalesOrders");
        salesOrderItemsCache = new HashMap<>();
        for (ODataEntity entity: entities) {
            SalesOrderItems soItem = new SalesOrderItems(entity);
            salesOrderItemsCache.put(soItem.getSO_ID(),soItem);
        }
    }


}
