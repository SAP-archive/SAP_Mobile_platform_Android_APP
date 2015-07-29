package com.sap.epm.mbo;


import java.util.Map;

import com.sap.epm.mbo.intml.BusinessPartnerMapping;
import com.sap.smp.client.odata.ODataEntity;
import com.sap.smp.client.odata.ODataPropMap;
import com.sap.smp.client.odata.ODataProperty;
import com.sap.smp.client.odata.impl.ODataEntityDefaultImpl;
import com.sap.smp.client.odata.impl.ODataPropertyDefaultImpl;

public class BusinessPartner  {

    private ODataEntity entity;

	private boolean _isDirty = false;
    private String __BP_ID ;
    private String __BP_ROLE ;
    private String __EMAIL_ADDRESS ;
    private String __PHONE_NUMBER ;
    private String __FAX_NUMBER ;
    private String __WEB_ADDRESS ;
    private String __COMPANY_NAME ;
    private String __LEGAL_FORM ;
    private String __CURRENCY_CODE ;
    private String __CITY ;
    private String __POSTAL_CODE ;
    private String __STREET ;
    private String __BUILDING ;
    private String __COUNTRY ;
    private String __ADDRESS_TYPE ;
    private String editResourceURL;
	
    public BusinessPartner(ODataEntity entity){
        this.entity = entity;
        init();
    }

    public BusinessPartner(String ID, String name, String street, String city, String country, String webaddress){
        ODataEntity newEntity = null;
        newEntity = new ODataEntityDefaultImpl(BusinessPartnerMapping.ENTITY_TYPE);

        newEntity.getProperties().put(BusinessPartnerMapping.BPID,
                new ODataPropertyDefaultImpl(BusinessPartnerMapping.BPID, ID));
        newEntity.getProperties().put(BusinessPartnerMapping.COMPANYNAME,
                new ODataPropertyDefaultImpl(BusinessPartnerMapping.COMPANYNAME, name));
        newEntity.getProperties().put(BusinessPartnerMapping.STREET,
                new ODataPropertyDefaultImpl(BusinessPartnerMapping.STREET, street));
        newEntity.getProperties().put(BusinessPartnerMapping.CITY,
                new ODataPropertyDefaultImpl(BusinessPartnerMapping.CITY, city));
        newEntity.getProperties().put(BusinessPartnerMapping.COUNTRY,
                new ODataPropertyDefaultImpl(BusinessPartnerMapping.COUNTRY, country));
        newEntity.getProperties().put(BusinessPartnerMapping.WEBADDRESS,
                new ODataPropertyDefaultImpl(BusinessPartnerMapping.WEBADDRESS, webaddress));

        this.entity = newEntity;
    }

	private void init() {
        ODataProperty property;
        ODataPropMap properties;

        properties = entity.getProperties();
        property = properties.get(BusinessPartnerMapping.ADDRESSTYPE);
        this.setADDRESS_TYPE((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.BPID);
        this.setBP_ID((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.BPROLE);
        this.setBP_ROLE((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.BUILDING);
        this.setBUILDING((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.CITY);
        this.setCITY((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.COMPANYNAME);
        this.setCOMPANY_NAME((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.COUNTRY);
        this.setCOUNTRY((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.CURRENCYCODE);
        this.setCURRENCY_CODE((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.EMAILADDRESS);
        this.setEMAIL_ADDRESS((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.FAXNUMBER);
        this.setFAX_NUMBER((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.LEGALFORM);
        this.setLEGAL_FORM((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.PHONENUMBER);
        this.setPHONE_NUMBER((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.POSTALCODE);
        this.setPOSTAL_CODE((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.STREET);
        this.setSTREET((String) property.getValue());

        property = properties.get(BusinessPartnerMapping.WEBADDRESS);
        this.setWEB_ADDRESS((String) property.getValue());

        this.editResourceURL = entity.getEditResourcePath();

 	}

    public ODataEntity getEntity(){
        return entity;
    }

    /**
     * get the value of BP_ID  
     */
    public String getBP_ID()
    {
        
        return __BP_ID;
    }
    
    /**
     * Set the value of BP_ID  
     */
    public void setBP_ID(String value)
    {
        if ((__BP_ID == null) != (value == null) || (value != null && ! value.equals(__BP_ID)))
        {
            _isDirty = true;
        }
        __BP_ID = value;
    } 
    
    
    /**
     * get the value of BP_ROLE  
     */
    public String getBP_ROLE()
    {
        
        return __BP_ROLE;
    }
    
    /**
     * Set the value of BP_ROLE  
     */
    public void setBP_ROLE(String value)
    {
        if ((__BP_ROLE == null) != (value == null) || (value != null && ! value.equals(__BP_ROLE)))
        {
            _isDirty = true;
        }
        __BP_ROLE = value;
    }       
    /**
     * get the value of EMAIL_ADDRESS  
     */
    public String getEMAIL_ADDRESS()
    {
        
        return __EMAIL_ADDRESS;
    }
    
    /**
     * Set the value of EMAIL_ADDRESS  
     */
    public void setEMAIL_ADDRESS(String value)
    {
        if ((__EMAIL_ADDRESS == null) != (value == null) || (value != null && ! value.equals(__EMAIL_ADDRESS)))
        {
            _isDirty = true;
        }
        __EMAIL_ADDRESS = value;
    }       
    /**
     * get the value of PHONE_NUMBER  
     */
    public String getPHONE_NUMBER()
    {
        
        return __PHONE_NUMBER;
    }
    
    /**
     * Set the value of PHONE_NUMBER  
     */
    public void setPHONE_NUMBER(String value)
    {
        if ((__PHONE_NUMBER == null) != (value == null) || (value != null && ! value.equals(__PHONE_NUMBER)))
        {
            _isDirty = true;
        }
        __PHONE_NUMBER = value;
    }       
    /**
     * get the value of FAX_NUMBER  
     */
    public String getFAX_NUMBER()
    {
        
        return __FAX_NUMBER;
    }
    
    /**
     * Set the value of FAX_NUMBER  
     */
    public void setFAX_NUMBER(String value)
    {
        if ((__FAX_NUMBER == null) != (value == null) || (value != null && ! value.equals(__FAX_NUMBER)))
        {
            _isDirty = true;
        }
        __FAX_NUMBER = value;
    }       
    /**
     * get the value of WEB_ADDRESS  
     */
    public String getWEB_ADDRESS()
    {
        
        return __WEB_ADDRESS;
    }
    
    /**
     * Set the value of WEB_ADDRESS  
     */
    public void setWEB_ADDRESS(String value)
    {
        if ((__WEB_ADDRESS == null) != (value == null) || (value != null && ! value.equals(__WEB_ADDRESS)))
        {
            _isDirty = true;
        }
        __WEB_ADDRESS = value;
    }       
    /**
     * get the value of COMPANY_NAME  
     */
    public String getCOMPANY_NAME()
    {
        
        return __COMPANY_NAME;
    }
    
    /**
     * Set the value of COMPANY_NAME  
     */
    public void setCOMPANY_NAME(String value)
    {
        if ((__COMPANY_NAME == null) != (value == null) || (value != null && ! value.equals(__COMPANY_NAME)))
        {
            _isDirty = true;
        }
        __COMPANY_NAME = value;
    }       
    /**
     * get the value of LEGAL_FORM  
     */
    public String getLEGAL_FORM()
    {
        
        return __LEGAL_FORM;
    }
    
    /**
     * Set the value of LEGAL_FORM  
     */
    public void setLEGAL_FORM(String value)
    {
        if ((__LEGAL_FORM == null) != (value == null) || (value != null && ! value.equals(__LEGAL_FORM)))
        {
            _isDirty = true;
        }
        __LEGAL_FORM = value;
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
     * get the value of CITY  
     */
    public String getCITY()
    {
        
        return __CITY;
    }
    
    /**
     * Set the value of CITY  
     */
    public void setCITY(String value)
    {
        if ((__CITY == null) != (value == null) || (value != null && ! value.equals(__CITY)))
        {
            _isDirty = true;
        }
        __CITY = value;
    }       
    /**
     * get the value of POSTAL_CODE  
     */
    public String getPOSTAL_CODE()
    {
        
        return __POSTAL_CODE;
    }
    
    /**
     * Set the value of POSTAL_CODE  
     */
    public void setPOSTAL_CODE(String value)
    {
        if ((__POSTAL_CODE == null) != (value == null) || (value != null && ! value.equals(__POSTAL_CODE)))
        {
            _isDirty = true;
        }
        __POSTAL_CODE = value;
    }       
    /**
     * get the value of STREET  
     */
    public String getSTREET()
    {
        
        return __STREET;
    }
    
    /**
     * Set the value of STREET  
     */
    public void setSTREET(String value)
    {
        if ((__STREET == null) != (value == null) || (value != null && ! value.equals(__STREET)))
        {
            _isDirty = true;
        }
        __STREET = value;
    }       
    /**
     * get the value of BUILDING  
     */
    public String getBUILDING()
    {
        
        return __BUILDING;
    }
    
    /**
     * Set the value of BUILDING  
     */
    public void setBUILDING(String value)
    {
        if ((__BUILDING == null) != (value == null) || (value != null && ! value.equals(__BUILDING)))
        {
            _isDirty = true;
        }
        __BUILDING = value;
    }       
    /**
     * get the value of COUNTRY  
     */
    public String getCOUNTRY()
    {
        
        return __COUNTRY;
    }
    
    /**
     * Set the value of COUNTRY  
     */
    public void setCOUNTRY(String value)
    {
        if ((__COUNTRY == null) != (value == null) || (value != null && ! value.equals(__COUNTRY)))
        {
            _isDirty = true;
        }
        __COUNTRY = value;
    }       
    /**
     * get the value of ADDRESS_TYPE  
     */
    public String getADDRESS_TYPE()
    {
        
        return __ADDRESS_TYPE;
    }
    
    /**
     * Set the value of ADDRESS_TYPE  
     */
    public void setADDRESS_TYPE(String value)
    {
        if ((__ADDRESS_TYPE == null) != (value == null) || (value != null && ! value.equals(__ADDRESS_TYPE)))
        {
            _isDirty = true;
        }
        __ADDRESS_TYPE = value;
    }
    
    
	public boolean isDirty() {
		return _isDirty;
	}

	public void setIsDirty(boolean dirty) {
		_isDirty = dirty;
	}

    public String getEditResourceURL() {
        return editResourceURL;
    }

    public void setEditResourceURL(String editResourceURL) {
        this.editResourceURL = editResourceURL;
    }

    @Override
	public String toString() {
		return "BusinessPartner [entry=" /*+ entry + ", isJSON=" + isJSON*/
				+ ", _isDirty=" + _isDirty + ",  __BP_ID="
				+ __BP_ID + ", __BP_ROLE=" + __BP_ROLE + ", __EMAIL_ADDRESS="
				+ __EMAIL_ADDRESS + ", __PHONE_NUMBER=" + __PHONE_NUMBER
				+ ", __FAX_NUMBER=" + __FAX_NUMBER + ", __WEB_ADDRESS="
				+ __WEB_ADDRESS + ", __COMPANY_NAME=" + __COMPANY_NAME
				+ ", __LEGAL_FORM=" + __LEGAL_FORM + ", __CURRENCY_CODE="
				+ __CURRENCY_CODE + ", __CITY=" + __CITY + ", __POSTAL_CODE="
				+ __POSTAL_CODE + ", __STREET=" + __STREET + ", __BUILDING="
				+ __BUILDING + ", __COUNTRY=" + __COUNTRY + ", __ADDRESS_TYPE="
				+ __ADDRESS_TYPE /*+ ", __salesOrders=" + __salesOrders*/ + "]";
	}


	
}
