package com.sap.epm.odata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.sap.epm.app.UIListener;

/**
 * Created by i821448 on 15-06-11.
 *
 */
public class BaseResponseHandler {
    private static final String TAG = BaseResponseHandler.class.getSimpleName();


    protected UIListener uiListener;
    protected boolean finishSuccessful;
    protected Exception exception;

    private final int SUCCESS = 0;
    private final int ERROR = -1;

    private Handler uiHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(Message msg) {

            if (msg.what == SUCCESS) {
                // Notify the Activity the is complete
                String key = (String) msg.obj;
                uiListener.onODataRequestSuccess(1, key);
            } else if (msg.what == ERROR) {
                Exception e = (Exception) msg.obj;
                uiListener.onODataRequestError(1, e);
            }
        }
    };

    public BaseResponseHandler(UIListener uiListener) {
        super();
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
