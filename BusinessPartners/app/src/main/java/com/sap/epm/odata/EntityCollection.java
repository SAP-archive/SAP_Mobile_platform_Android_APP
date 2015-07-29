package com.sap.epm.odata;

import android.content.Context;
import android.util.Log;

import com.sap.epm.mbo.BusinessPartner;
import com.sap.maf.tools.logon.core.LogonCore;
import com.sap.maf.tools.logon.core.LogonCoreContext;
import com.sap.maf.tools.logon.logonui.api.LogonUIFacade;
import com.sap.smp.client.httpc.HttpConversationManager;
import com.sap.smp.client.httpc.IManagerConfigurator;
import com.sap.smp.client.odata.ODataEntity;
import com.sap.smp.client.odata.offline.ODataOfflineStore;
import com.sap.smp.client.odata.offline.ODataOfflineStoreOptions;
import com.sap.smp.client.odata.offline.ODataOfflineStoreState;
import com.sap.smp.client.odata.store.ODataRequestListener;
import com.sap.smp.client.odata.store.ODataRequestParamSingle;
import com.sap.smp.client.odata.store.impl.ODataRequestParamSingleDefaultImpl;

import java.net.URL;

/**
 * Created by i821448 on 15-05-12.

 */
public class EntityCollection {
    public static final String TAG = EntityCollection.class.getSimpleName();
    private static ODataOfflineStore offlineStore;
    private static String storeState;

    public static boolean isOfflineStoreOpen(){
        boolean isOpen = false;
        if (offlineStore!=null && ODataOfflineStoreState.ODataOfflineStoreOpen.name().equals(storeState)){
            isOpen = true;
        }
        return isOpen;
    }


    public static void setStoreState(String state){
        storeState = state;
    }

    public static String getStoreState(){
        return storeState;
    }

    /**
     * Open online store
     * @param context application context
     * @param storeListener store listener that handle different stages during the initialization of the offline store
     * @throws OfflineGenericException
     */
    public static void openOfflineStore(Context context, OfflineStoreListener storeListener ) throws OfflineGenericException{

        if (!isOfflineStoreOpen()){
            try {
                //This instantiate the native UDB libraries which are located in the libodataofflinejni.so file
                ODataOfflineStore.globalInit();

                LogonCoreContext lgCtx = LogonCore.getInstance().getLogonContext();
                String endPointURL = lgCtx.getAppEndPointUrl();
                URL url = new URL(endPointURL);
                Log.d(TAG, "openOfflineStore: appcid:" + lgCtx.getConnId());
                Log.d(TAG, "openOfflineStore: endpointurl:"+ endPointURL);

                // Define the offline store options.
                // Connection parameter and credentials and the application connection id we got at the registration
                ODataOfflineStoreOptions options = new ODataOfflineStoreOptions();
                options.host = url.getHost();
                options.port = String.valueOf(url.getPort());
                options.enableHTTPS = lgCtx.isHttps();
                options.serviceRoot= endPointURL;

                //Obtain information from the registration (i.e credentials) and access the data from the backend
                IManagerConfigurator configurator = LogonUIFacade.getInstance().getLogonConfigurator(context);
                HttpConversationManager manager = new HttpConversationManager(context);
                configurator.configure(manager);
                options.conversationManager = manager;

                options.enableRepeatableRequests = false;
                options.storeName="flight";

                //This defines the oData collections which will be stored in the offline store
                options.addDefiningRequest("reg1", "BusinessPartners?$expand=SalesOrders/Items", false);
//                options.addDefiningRequest("req2", "Products?$filter=Category eq 'Others'", false);

                //Open offline store
                offlineStore = new ODataOfflineStore(context);

                //Assign store listener
                offlineStore.setOfflineStoreListener(storeListener);
                offlineStore.openStoreAsync(options);

                Log.d(TAG, "openOfflineStore: library version"+ ODataOfflineStore.libraryVersion());

            } catch (Exception e) {
                throw new OfflineGenericException(e);
            }

        }
    }

    /**
     * Send GET request to the offline store
     * @param collection URL of the collection
     * @param customTag description of the request
     * @param requestListener request listener
     * @throws OfflineGenericException
     */
    public static void sendGETRequest(String collection, String customTag, ODataRequestListener requestListener) throws OfflineGenericException{

        if (isOfflineStoreOpen()){

            try {

                ODataRequestParamSingle request = new ODataRequestParamSingleDefaultImpl();
                request.setMode(ODataRequestParamSingle.Mode.Read);
                request.setResourcePath(collection);
                request.setCustomTag(customTag);

                offlineStore.scheduleRequest (request,requestListener );

            } catch (Exception e) {
                throw new OfflineGenericException(e);
            }
        }
    }

    public static void sendPOSTRequest(ODataEntity newEntity, String collection, ODataRequestListener requestListener) throws OfflineGenericException{
        if (isOfflineStoreOpen()) {

            try {
                offlineStore.scheduleCreateEntity(newEntity, collection, requestListener, null);

            } catch (Exception e) {
                throw new OfflineGenericException(e);
            }
        }
    }


    /**
     * execute flush operation
     * @param flushtListener flush listener
     * @throws OfflineGenericException
     */
    public static void sendFlush( OfflineFlushListener flushtListener) throws OfflineGenericException{

        if (isOfflineStoreOpen()){

            try {

                offlineStore.scheduleFlushQueuedRequests(flushtListener);

            } catch (Exception e) {
                throw new OfflineGenericException(e);
            }
        }
    }


    /**
     * execute refresh operation
     * @param refreshListener refresh listener
     * @throws OfflineGenericException
     */
    public static void sendRefresh( OfflineRefreshListener refreshListener) throws OfflineGenericException{

        if (isOfflineStoreOpen()){

            try {

                offlineStore.scheduleRefresh(refreshListener);

            } catch (Exception e) {
                throw new OfflineGenericException(e);
            }
        }
    }



}
