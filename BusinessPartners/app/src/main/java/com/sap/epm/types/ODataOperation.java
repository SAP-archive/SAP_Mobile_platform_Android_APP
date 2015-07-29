package com.sap.epm.types;

public enum ODataOperation {
	OpenOfflineStore(10),
	GetBusinessPartner(20),
	GetSalesOrders(30),
	GetSalesOrdersItems(40),
	CreateBusinessPartner(50),
	Flush(60),
	Refresh(70);

	private final int value;

	ODataOperation(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
