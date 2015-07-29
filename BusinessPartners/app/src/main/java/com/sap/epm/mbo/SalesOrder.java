package com.sap.epm.mbo;

import java.math.BigDecimal;
import com.sap.epm.mbo.intml.SalesOrderMapping;
import com.sap.smp.client.odata.ODataEntity;
import com.sap.smp.client.odata.ODataPropMap;
import com.sap.smp.client.odata.ODataProperty;

public class SalesOrder {
	
	private static final String TAG = SalesOrder.class.getSimpleName();
	
    private String __SO_ID ;
    
    private String __NOTE ;
    
    private String __BUYER_ID ;
    
    private String __BUYER_NAME ;
    
    private String __CURRENCY_CODE ;
    
    private BigDecimal __GROSS_AMOUNT ;
    
    private BigDecimal __GROSS_AMOUNT_EXT ;
    
    private BigDecimal __NET_AMOUNT ;
    
    private BigDecimal __NET_AMOUNT_EXT ;
    
    private BigDecimal __TAX_AMOUNT ;
    
    private BigDecimal __TAX_AMOUNT_EXT ;
    
    private String __LIFECYCLE_STATUS ;
    
    private String __BILLING_STATUS ;
    
    private String __DELIVERY_STATUS ;

    private boolean _isDirty = false;

    public ODataEntity entity;
    
    public SalesOrder (ODataEntity entity) {
		this.entity = entity;
		init();
    }
    
    private void init() {
    	if (entity != null) {
            ODataProperty property;
            ODataPropMap properties;

            properties = entity.getProperties();

            property = properties.get(SalesOrderMapping.BILLING_STATUS);
            this.setBILLING_STATUS((String) property.getValue());

            property = properties.get(SalesOrderMapping.BUYER_ID);
            this.setBUYER_ID((String) property.getValue());

            property = properties.get(SalesOrderMapping.BUYER_NAME);
            this.setBUYER_NAME((String) property.getValue());

            property = properties.get(SalesOrderMapping.CURRENCY_CODE);
            this.setCURRENCY_CODE((String) property.getValue());

            property = properties.get(SalesOrderMapping.DELIVERY_STATUS);
            this.setDELIVERY_STATUS((String) property.getValue());

            property = properties.get(SalesOrderMapping.LIFECYCLE_STATUS);
            this.setLIFECYCLE_STATUS((String) property.getValue());

            property = properties.get(SalesOrderMapping.NOTE);
            this.setNOTE((String) property.getValue());

            property = properties.get(SalesOrderMapping.SO_ID);
            this.setSO_ID((String) property.getValue());

/*
    		try {
	    		this.setGROSS_AMOUNT(new BigDecimal( entry.getPropertyValue(SalesOrderMapping.GROSS_AMOUNT)));
	    		this.setGROSS_AMOUNT_EXT(new BigDecimal(entry.getPropertyValue(SalesOrderMapping.GROSS_AMOUNT_EXT)));
	    		this.setNET_AMOUNT(new BigDecimal(entry.getPropertyValue(SalesOrderMapping.NET_AMOUNT)));
	    		this.setNET_AMOUNT_EXT(new BigDecimal(entry.getPropertyValue(SalesOrderMapping.NET_AMOUNT_EXT)));
	    		this.setTAX_AMOUNT(new BigDecimal(entry.getPropertyValue(SalesOrderMapping.TAX_AMOUNT)));
	    		this.setTAX_AMOUNT_EXT(new BigDecimal(entry.getPropertyValue(SalesOrderMapping.TAX_AMOUNT_EXT)));
    		} catch (Exception ex) {

    		}
    		*/
    		
    	}
    }
    
    
    /**
     * get the value of SO_ID  
     */
    public String getSO_ID()
    {
        
        return __SO_ID;
    }
    
    /**
     * Set the value of SO_ID  
     */
    public void setSO_ID(String value)
    {
        if ((__SO_ID == null) != (value == null) || (value != null && ! value.equals(__SO_ID)))
        {
            _isDirty = true;
        }
        __SO_ID = value;
    }       
    /**
     * get the value of NOTE  
     */
    public String getNOTE()
    {
        
        return __NOTE;
    }
    
    /**
     * Set the value of NOTE  
     */
    public void setNOTE(String value)
    {
        if ((__NOTE == null) != (value == null) || (value != null && ! value.equals(__NOTE)))
        {
            _isDirty = true;
        }
        __NOTE = value;
    }       
    /**
     * get the value of BUYER_ID  
     */
    public String getBUYER_ID()
    {
        
        return __BUYER_ID;
    }
    
    /**
     * Set the value of BUYER_ID  
     */
    public void setBUYER_ID(String value)
    {
        if ((__BUYER_ID == null) != (value == null) || (value != null && ! value.equals(__BUYER_ID)))
        {
            _isDirty = true;
        }
        __BUYER_ID = value;
    }       
    /**
     * get the value of BUYER_NAME  
     */
    public String getBUYER_NAME()
    {
        
        return __BUYER_NAME;
    }
    
    /**
     * Set the value of BUYER_NAME  
     */
    public void setBUYER_NAME(String value)
    {
        if ((__BUYER_NAME == null) != (value == null) || (value != null && ! value.equals(__BUYER_NAME)))
        {
            _isDirty = true;
        }
        __BUYER_NAME = value;
    }       
    /**
     * get the value of CURRENCY_CODE  
     */
    public String getCURRENCY_CODE()
    {
        
        return __CURRENCY_CODE;
    }
    
    /**
     * Set the value of CURRENCY_CODE  
     */
    public void setCURRENCY_CODE(String value)
    {
        if ((__CURRENCY_CODE == null) != (value == null) || (value != null && ! value.equals(__CURRENCY_CODE)))
        {
            _isDirty = true;
        }
        __CURRENCY_CODE = value;
    }       
    /**
     * get the value of GROSS_AMOUNT  
     */
    public BigDecimal getGROSS_AMOUNT()
    {
        
        return __GROSS_AMOUNT;
    }
    
    /**
     * Set the value of GROSS_AMOUNT  
     */
    public void setGROSS_AMOUNT(BigDecimal value)
    {
        if ((__GROSS_AMOUNT == null) != (value == null) || (value != null && ! value.equals(__GROSS_AMOUNT)))
        {
            _isDirty = true;
        }
        __GROSS_AMOUNT = value;
    }       
    /**
     * get the value of GROSS_AMOUNT_EXT  
     */
    public BigDecimal getGROSS_AMOUNT_EXT()
    {
        
        return __GROSS_AMOUNT_EXT;
    }
    
    /**
     * Set the value of GROSS_AMOUNT_EXT  
     */
    public void setGROSS_AMOUNT_EXT(BigDecimal value)
    {
        if ((__GROSS_AMOUNT_EXT == null) != (value == null) || (value != null && ! value.equals(__GROSS_AMOUNT_EXT)))
        {
            _isDirty = true;
        }
        __GROSS_AMOUNT_EXT = value;
    }       
    /**
     * get the value of NET_AMOUNT  
     */
    public BigDecimal getNET_AMOUNT()
    {
        
        return __NET_AMOUNT;
    }
    
    /**
     * Set the value of NET_AMOUNT  
     */
    public void setNET_AMOUNT(BigDecimal value)
    {
        if ((__NET_AMOUNT == null) != (value == null) || (value != null && ! value.equals(__NET_AMOUNT)))
        {
            _isDirty = true;
        }
        __NET_AMOUNT = value;
    }       
    /**
     * get the value of NET_AMOUNT_EXT  
     */
    public BigDecimal getNET_AMOUNT_EXT()
    {
        
        return __NET_AMOUNT_EXT;
    }
    
    /**
     * Set the value of NET_AMOUNT_EXT  
     */
    public void setNET_AMOUNT_EXT(BigDecimal value)
    {
        if ((__NET_AMOUNT_EXT == null) != (value == null) || (value != null && ! value.equals(__NET_AMOUNT_EXT)))
        {
            _isDirty = true;
        }
        __NET_AMOUNT_EXT = value;
    }       
    /**
     * get the value of TAX_AMOUNT  
     */
    public BigDecimal getTAX_AMOUNT()
    {
        
        return __TAX_AMOUNT;
    }
    
    /**
     * Set the value of TAX_AMOUNT  
     */
    public void setTAX_AMOUNT(BigDecimal value)
    {
        if ((__TAX_AMOUNT == null) != (value == null) || (value != null && ! value.equals(__TAX_AMOUNT)))
        {
            _isDirty = true;
        }
        __TAX_AMOUNT = value;
    }       
    /**
     * get the value of TAX_AMOUNT_EXT  
     */
    public BigDecimal getTAX_AMOUNT_EXT()
    {
        
        return __TAX_AMOUNT_EXT;
    }
    
    /**
     * Set the value of TAX_AMOUNT_EXT  
     */
    public void setTAX_AMOUNT_EXT(BigDecimal value)
    {
        if ((__TAX_AMOUNT_EXT == null) != (value == null) || (value != null && ! value.equals(__TAX_AMOUNT_EXT)))
        {
            _isDirty = true;
        }
        __TAX_AMOUNT_EXT = value;
    }       
    /**
     * get the value of LIFECYCLE_STATUS  
     */
    public String getLIFECYCLE_STATUS()
    {
        
        return __LIFECYCLE_STATUS;
    }
    
    /**
     * Set the value of LIFECYCLE_STATUS  
     */
    public void setLIFECYCLE_STATUS(String value)
    {
        if ((__LIFECYCLE_STATUS == null) != (value == null) || (value != null && ! value.equals(__LIFECYCLE_STATUS)))
        {
            _isDirty = true;
        }
        __LIFECYCLE_STATUS = value;
    }       
    /**
     * get the value of BILLING_STATUS  
     */
    public String getBILLING_STATUS()
    {
        
        return __BILLING_STATUS;
    }
    
    /**
     * Set the value of BILLING_STATUS  
     */
    public void setBILLING_STATUS(String value)
    {
        if ((__BILLING_STATUS == null) != (value == null) || (value != null && ! value.equals(__BILLING_STATUS)))
        {
            _isDirty = true;
        }
        __BILLING_STATUS = value;
    }       
    /**
     * get the value of DELIVERY_STATUS  
     */
    public String getDELIVERY_STATUS()
    {
        
        return __DELIVERY_STATUS;
    }
    
    /**
     * Set the value of DELIVERY_STATUS  
     */
    public void setDELIVERY_STATUS(String value)
    {
        if ((__DELIVERY_STATUS == null) != (value == null) || (value != null && ! value.equals(__DELIVERY_STATUS)))
        {
            _isDirty = true;
        }
        __DELIVERY_STATUS = value;
    }

    public boolean isDirty() {
        return _isDirty;
    }

    public void setIsDirty(boolean dirty) {
        _isDirty = dirty;
    }

}
