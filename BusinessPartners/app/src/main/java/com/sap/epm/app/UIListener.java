package com.sap.epm.app;


public interface UIListener {
	void onODataRequestError(int operation, Exception e);
	void onODataRequestSuccess(int operation, String key);
}
