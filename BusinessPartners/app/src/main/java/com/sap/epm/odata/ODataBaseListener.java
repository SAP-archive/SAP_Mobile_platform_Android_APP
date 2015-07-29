package com.sap.epm.odata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.sap.epm.app.UIListener;
import com.sap.smp.client.odata.store.ODataRequestListener;

import java.lang.ref.WeakReference;

/**
 * Created by i821448 on 15-06-11.
 *
 */
public class ODataBaseListener {
    private static final String TAG = ODataBaseListener.class.getSimpleName();


    protected UIListener uiListener;
    protected int operation;

    private final int SUCCESS = 0;
    private final int ERROR = -1;

    private Handler uiHandler = new myHandler(this);

    private static class myHandler extends Handler {
        private WeakReference<ODataBaseListener> baseListenerWeakReference;

        public myHandler(ODataBaseListener oDataBaseListener){
            super(Looper.getMainLooper());
            baseListenerWeakReference = new WeakReference<ODataBaseListener>(oDataBaseListener);
        }

        @Override
        public void handleMessage(Message msg) {
            ODataBaseListener baseListener =  baseListenerWeakReference.get();

            if (msg.what == baseListener.SUCCESS) {
                // Notify the Activity the is complete
                String key = (String) msg.obj;
                baseListener.uiListener.onODataRequestSuccess(baseListener.operation, key);
            } else if (msg.what == baseListener.ERROR) {
                Exception e = (Exception) msg.obj;
                baseListener.uiListener.onODataRequestError(baseListener.operation, e);
            }
        }
    }

    public ODataBaseListener(int operation, UIListener uiListener) {
        super();
        this.operation = operation;
        this.uiListener = uiListener;
    }


    /*****************
     * Utils Methods
     *****************/


    /**
     * Notify the OnlineUIListener that the request was successful.
     */
    protected void notifySuccessToListener(String key) {
        Message msg = uiHandler.obtainMessage();
        msg.what = SUCCESS;
        msg.obj = key;
        uiHandler.sendMessage(msg);
        Log.d(TAG, "notifySuccessToListener: " + key);
    }

    /**
     * Notify the OnlineUIListener that the request has an error.
     *
     * @param exception an Exception that denotes the error that occurred.
     */
    protected void notifyErrorToListener(Exception exception) {
        Message msg = uiHandler.obtainMessage();
        msg.what = ERROR;
        msg.obj = exception;
        uiHandler.sendMessage(msg);
        Log.e(TAG, "notifyErrorToListener", exception);
    }



}
