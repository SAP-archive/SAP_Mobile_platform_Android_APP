package com.sap.epm.odata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.epm.mbo.BusinessPartner;
import com.sap.epm.mbo.SalesOrder;
import com.sap.epm.mbo.SalesOrderItems;
import com.sap.epm.types.ODataOperation;
import com.sap.smp.client.odata.ODataEntity;
import com.sap.smp.client.odata.ODataEntitySet;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.store.ODataRequestExecution;
import com.sap.smp.client.odata.store.ODataRequestListener;
import com.sap.smp.client.odata.store.ODataResponse;
import com.sap.smp.client.odata.store.ODataResponseSingle;

import java.util.List;
import java.util.Map;

/**
 * Created by i821448 on 15-05-11.
 *
 */
public class OfflineRequestListener extends ODataBaseListener implements ODataRequestListener{
    private static final String TAG = OfflineRequestListener.class.getSimpleName();

    public OfflineRequestListener(int operation, UIListener uiListener) {
        super(operation, uiListener);
    }

    /*****************
     * Methods that implements ODataRequestListener interface
     *****************/


    @Override
    public void requestStarted(ODataRequestExecution oDataRequestExecution) {
        Log.d(TAG, "requestStarted");
    }

    @Override
    public void requestCacheResponse(ODataRequestExecution oDataRequestExecution) {
        Log.d(TAG, "requestCacheResponse");

    }

    @Override
    public void requestServerResponse(ODataRequestExecution oDataRequestExecution) {
        Log.d(TAG, "requestServerResponse");
        if (oDataRequestExecution!=null && oDataRequestExecution.getResponse() !=null) {
            String customTag = oDataRequestExecution.getRequest().getCustomTag();
            //Parse the response
            ODataResponseSingle response = (ODataResponseSingle) oDataRequestExecution.getResponse();
            //Get the http status code
            Map<ODataResponse.Headers, String> headerMap = response.getHeaders();
            String code = headerMap.get(ODataResponse.Headers.Code);
            Log.d(TAG, "requestServerResponse - status code " + code);
            if (operation == ODataOperation.GetBusinessPartner.getValue()){
                //Get the response payload
                ODataEntitySet feed = (ODataEntitySet) response.getPayload();
                //Get the list of ODataEntity
                List<ODataEntity> entities = feed.getEntities();

                BusinessPartnerEntityCollection.getInstance(uiListener).setBusinessPartners(entities);

            } else if (operation == ODataOperation.GetSalesOrders.getValue()){
                //Get the response payload
                ODataEntitySet feed = (ODataEntitySet) response.getPayload();
                //Get the list of ODataEntity
                List<ODataEntity> entities = feed.getEntities();
                SalesOrderEntityCollection.getInstance().setSalesOrders(entities);

            } else if (operation == ODataOperation.GetSalesOrdersItems.getValue()){
                //Get the response payload
                ODataEntitySet feed = (ODataEntitySet) response.getPayload();
                //Get the list of ODataEntity
                List<ODataEntity> entities = feed.getEntities();
                SalesOrderItemEntityCollection.getInstance().setSalesOrderItems(entities);

            }
            notifySuccessToListener("success");

        } else {
            notifyErrorToListener(new OfflineGenericException("no response"));
        }

    }

    @Override
    public void requestFailed(ODataRequestExecution oDataRequestExecution, ODataException e) {
        Log.d(TAG, "requestFailed");
        notifyErrorToListener(e);

    }

    @Override
    public void requestFinished(ODataRequestExecution oDataRequestExecution) {
        Log.d(TAG, "requestFinished");

    }


}
