package com.sap.epm.odata;

import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.offline.ODataOfflineStore;
import com.sap.smp.client.odata.offline.ODataOfflineStoreListener;
import com.sap.smp.client.odata.offline.ODataOfflineStoreNotification;
import com.sap.smp.client.odata.offline.ODataOfflineStoreState;

/**
 * Created by i821448 on 15-05-13.
 *
 */
public class OfflineStoreListener extends ODataBaseListener implements ODataOfflineStoreListener{
    private static final String TAG = OfflineStoreListener.class.getSimpleName();

    public OfflineStoreListener(int operation, UIListener uiListener) {
        super(operation, uiListener);
    }

    /*****************
     * Methods that implements ODataRequestListener interface
     *****************/

    @Override
    public void offlineStoreStateChanged(ODataOfflineStore oDataOfflineStore, ODataOfflineStoreState oDataOfflineStoreState) {
        Log.d(TAG, "offlineStoreStateChanged " + oDataOfflineStoreState.name());
        EntityCollection.setStoreState(oDataOfflineStoreState.name());

    }

    @Override
    public void offlineStoreOpenFailed(ODataOfflineStore oDataOfflineStore, ODataException e) {
        Log.e(TAG, "offlineStoreOpenFailed ", e);
        notifyErrorToListener(e);

    }

    @Override
    public void offlineStoreOpenFinished(ODataOfflineStore oDataOfflineStore) {
        Log.d(TAG, "offlineStoreOpenFinished ");
        if (EntityCollection.isOfflineStoreOpen()){
            notifySuccessToListener("success");
        } else {
            notifyErrorToListener(new OfflineGenericException("store is not open"));
        }

    }

    @Override
    public void offlineStoreNotification(ODataOfflineStore oDataOfflineStore, ODataOfflineStoreNotification oDataOfflineStoreNotification) {
        Log.d(TAG, "offlineStoreNotification " + oDataOfflineStoreNotification.name());

    }


}
