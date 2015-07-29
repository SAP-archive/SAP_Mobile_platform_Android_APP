package com.sap.epm.odata;

import android.os.Handler;
import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.offline.ODataOfflineStore;
import com.sap.smp.client.odata.offline.ODataOfflineStoreFlushListener;

/**
 * Flush listener used to get progress updates of a flush operation
 */
public class OfflineFlushListener extends ODataBaseListener implements ODataOfflineStoreFlushListener {

    private static final String TAG = OfflineFlushListener.class.getSimpleName();

    public OfflineFlushListener(int operation, UIListener uiListener) {
        super(operation, uiListener);
    }


    @Override
    public void offlineStoreFlushStarted(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreFlushStarted");

    }

    @Override
    public void offlineStoreFlushFinished(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreFlushFinished");

    }

    @Override
    public void offlineStoreFlushSucceeded(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreFlushSucceeded");
        notifySuccessToListener(null);

    }

    @Override
    public void offlineStoreFlushFailed(ODataOfflineStore oDataOfflineStore, ODataException e) {
        Log.d(TAG, "offlineStoreFlushFailed");
        notifyErrorToListener(e);

    }
}
