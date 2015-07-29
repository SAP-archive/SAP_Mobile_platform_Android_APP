package com.sap.epm.mbo;

import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.epm.mbo.intml.SalesOrderItemsMapping;
import com.sap.epm.odata.EntityCollection;
import com.sap.epm.odata.OfflineGenericException;
import com.sap.epm.odata.OfflineRequestListener;
import com.sap.smp.client.odata.ODataEntity;
import com.sap.smp.client.odata.ODataPropMap;
import com.sap.smp.client.odata.ODataProperty;

public class SalesOrderItems {

    private static final String TAG = SalesOrderItems.class.getSimpleName();

    private String __SO_ID ;
    
    private String __SO_ITEM_POS ;
    
    private String __PRODUCT_ID ;
    
    private String __NOTE ;
    
    private String __CURRENCY_CODE ;
    
    private BigDecimal __GROSS_AMOUNT ;
    
    private BigDecimal __GROSS_AMOUNT_EXT ;
    
    private BigDecimal __NET_AMOUNT ;
    
    private BigDecimal __NET_AMOUNT_EXT ;
    
    private BigDecimal __TAX_AMOUNT ;
    
    private BigDecimal __TAX_AMOUNT_EXT ;
    
    private BigDecimal __QUANTITY ;
    
    private String __QUANTITY_UNIT ;
    
    private String __FK_ID;
    
    private boolean _isDirty = false;
    
    private ODataEntity entity;
    

    private static Map<String,SalesOrderItems> cache;
    
    public static final String COLLECTION = "Items";
    public static final String SALES_ORDER_ITEMS_TAG = "Items";

    public SalesOrderItems(ODataEntity entity) {
    	this.entity = entity;
    	init();
    }
    
    private void init() {
        if (entity != null) {
            ODataProperty property;
            ODataPropMap properties;

            properties = entity.getProperties();

            property = properties.get(SalesOrderItemsMapping.PRODUCT_ID);
            this.setPRODUCT_ID((String) property.getValue());

            property = properties.get(SalesOrderItemsMapping.CURRENCY_CODE);
            this.setCURRENCY_CODE((String) property.getValue());

            property = properties.get(SalesOrderItemsMapping.QUANTITY_UNIT);
            this.setQUANTITY_UNIT((String) property.getValue());

            property = properties.get(SalesOrderItemsMapping.SO_ITEM_POS);
            this.setSO_ITEM_POS((String) property.getValue());

            property = properties.get(SalesOrderItemsMapping.NOTE);
            this.setNOTE((String) property.getValue());

            property = properties.get(SalesOrderItemsMapping.SO_ID);
            this.setSO_ID((String) property.getValue());

            /*
    		try {
	    		this.setGROSS_AMOUNT(new BigDecimal( entry.getPropertyValue(SalesOrderItemsMapping.GROSS_AMOUNT)));
	    		this.setGROSS_AMOUNT_EXT(new BigDecimal(entry.getPropertyValue(SalesOrderItemsMapping.GROSS_AMOUNT_EXT)));
	    		this.setNET_AMOUNT(new BigDecimal(entry.getPropertyValue(SalesOrderItemsMapping.NET_AMOUNT)));
	    		this.setNET_AMOUNT_EXT(new BigDecimal(entry.getPropertyValue(SalesOrderItemsMapping.NET_AMOUNT_EXT)));
	    		this.setTAX_AMOUNT(new BigDecimal(entry.getPropertyValue(SalesOrderItemsMapping.TAX_AMOUNT)));
	    		this.setTAX_AMOUNT_EXT(new BigDecimal(entry.getPropertyValue(SalesOrderItemsMapping.TAX_AMOUNT_EXT)));
	    		
	    		this.setQUANTITY(new BigDecimal(entry.getPropertyValue(SalesOrderItemsMapping.QUANTITY)));
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
     * get the value of SO_ITEM_POS  
     */
    public String getSO_ITEM_POS()
    {
        
        return __SO_ITEM_POS;
    }
    
    /**
     * Set the value of SO_ITEM_POS  
     */
    public void setSO_ITEM_POS(String value)
    {
        if ((__SO_ITEM_POS == null) != (value == null) || (value != null && ! value.equals(__SO_ITEM_POS)))
        {
            _isDirty = true;
        }
        __SO_ITEM_POS = value;
    }       
    /**
     * get the value of PRODUCT_ID  
     */
    public String getPRODUCT_ID()
    {
        
        return __PRODUCT_ID;
    }
    
    /**
     * Set the value of PRODUCT_ID  
     */
    public void setPRODUCT_ID(String value)
    {
        if ((__PRODUCT_ID == null) != (value == null) || (value != null && ! value.equals(__PRODUCT_ID)))
        {
            _isDirty = true;
        }
        __PRODUCT_ID = value;
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
     * get the value of QUANTITY  
     */
    public BigDecimal getQUANTITY()
    {
        
        return __QUANTITY;
    }
    
    /**
     * Set the value of QUANTITY  
     */
    public void setQUANTITY(BigDecimal value)
    {
        if ((__QUANTITY == null) != (value == null) || (value != null && ! value.equals(__QUANTITY)))
        {
            _isDirty = true;
        }
        __QUANTITY = value;
    }       
    /**
     * get the value of QUANTITY_UNIT  
     */
    public String getQUANTITY_UNIT()
    {
        
        return __QUANTITY_UNIT;
    }
    
    /**
     * Set the value of QUANTITY_UNIT  
     */
    public void setQUANTITY_UNIT(String value)
    {
        if ((__QUANTITY_UNIT == null) != (value == null) || (value != null && ! value.equals(__QUANTITY_UNIT)))
        {
            _isDirty = true;
        }
        __QUANTITY_UNIT = value;
    }       
    
    public boolean isDirty() {
		return _isDirty;
	}

}
