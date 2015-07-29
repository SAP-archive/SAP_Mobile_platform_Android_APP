package com.sap.epm.odata;

/**
 * Created by i821448 on 15-05-12.
 *
 */
public class OfflineGenericException extends Exception{
    private static final long serialVersionUID = 1L;

    public OfflineGenericException(String errorMessage){
        super (errorMessage);
    }

    public OfflineGenericException(Throwable throwable){
        super (throwable);
    }
}
