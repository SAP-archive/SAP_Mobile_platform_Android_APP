package com.sap.epm.odata;

import android.os.Handler;
import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.offline.ODataOfflineStore;
import com.sap.smp.client.odata.offline.ODataOfflineStoreRefreshListener;

/**
 * Refresh Listener 
 */
public class OfflineRefreshListener extends ODataBaseListener implements ODataOfflineStoreRefreshListener{
    private static final String TAG = OfflineRefreshListener.class.getSimpleName();

    public OfflineRefreshListener(int operation, UIListener uiListener) {
        super(operation, uiListener);
    }


    @Override
    public void offlineStoreRefreshStarted(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreRefreshStarted");

    }

    @Override
    public void offlineStoreRefreshFinished(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreRefreshFinished");

    }

    @Override
    public void offlineStoreRefreshSucceeded(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreRefreshSucceeded");
        notifySuccessToListener(null);


    }

    @Override
    public void offlineStoreRefreshFailed(ODataOfflineStore oDataOfflineStore, ODataException e) {
        Log.d(TAG, "offlineStoreRefreshFailed");
        notifyErrorToListener(e);


    }
}
