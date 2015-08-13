package com.sap.epm.app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.sap.epm.R;
import com.sap.epm.odata.BusinessPartnerEntityCollection;
import com.sap.epm.odata.OfflineFlushListener;
import com.sap.epm.odata.OfflineGenericException;
import com.sap.epm.odata.OfflineRefreshListener;
import com.sap.epm.odata.OfflineRequestListener;
import com.sap.epm.types.ODataOperation;

public class BusinessPartnerListActivity extends Activity implements UIListener {
    public static final String TAG = BusinessPartnerListActivity.class.getSimpleName();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_partner_list);
	}


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        refresh();
    }


    private void refresh(){
        Log.d(TAG, "refresh");
        try {
            OfflineRequestListener requestListener = new OfflineRequestListener(ODataOperation.GetBusinessPartner.getValue(), this);
            BusinessPartnerEntityCollection bpCollection = BusinessPartnerEntityCollection.getInstance(this);
            bpCollection.findAll(requestListener);
        } catch (OfflineGenericException e) {
            Log.d(TAG, "refresh", e);
        }

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_business_partner_list, menu);
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item_refresh) {
            onSynchronize();
            return true;
        } else if (id == R.id.menu_item_save) {
            Intent i = new Intent(this, BusinessPartnerActivity.class);
            this.startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onODataRequestError(int operation, Exception e) {
        if (operation == ODataOperation.GetBusinessPartner.getValue()) {
            Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_getbp_fail), Toast.LENGTH_SHORT).show();
        } else if (operation == ODataOperation.Flush.getValue()){
            Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_flushbp_fail), Toast.LENGTH_SHORT).show();
        } else if (operation == ODataOperation.Refresh.getValue()){
            Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_refreshbp_fail), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onODataRequestSuccess(int operation, String key) {
        if (operation == ODataOperation.GetBusinessPartner.getValue()) {
            LayoutInflater inflater = LayoutInflater.from(BusinessPartnerListActivity.this);

            BusinessPartnerEntityCollection bpCollection = BusinessPartnerEntityCollection.getInstance(BusinessPartnerListActivity.this);


            BusinessPartnerListAdapter adapter2 = new BusinessPartnerListAdapter(inflater,
                    BusinessPartnerListActivity.this, bpCollection.getBusinessPartners());
            ListView lv = (ListView) findViewById(R.id.lvBusinessPartner);
            lv.setAdapter(adapter2);
            Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_getbp_success), Toast.LENGTH_SHORT).show();

        } else if (operation == ODataOperation.Flush.getValue()){
            Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_flushbp_success), Toast.LENGTH_SHORT).show();
            OfflineRefreshListener refreshListener = new OfflineRefreshListener(ODataOperation.Refresh.getValue(), this);
            BusinessPartnerEntityCollection bpCollection = BusinessPartnerEntityCollection.getInstance(BusinessPartnerListActivity.this);
            try {
                bpCollection.refresh(refreshListener);
            } catch (OfflineGenericException e) {
                Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_flushbp_fail), Toast.LENGTH_SHORT).show();
            }
        } else if (operation == ODataOperation.Refresh.getValue()){
            Toast.makeText(BusinessPartnerListActivity.this, getString(R.string.msg_refreshbp_success), Toast.LENGTH_SHORT).show();
        }

    }

    public void onSelectedItem(String fkId) {
        Intent i = new Intent(this, SalesOrderListActivity.class);
        i.putExtra("fkId", fkId);
        this.startActivity(i);

    }

    private void onSynchronize() {
        OfflineFlushListener flushListener = new OfflineFlushListener(ODataOperation.Flush.getValue(), this);
        BusinessPartnerEntityCollection bpCollection = BusinessPartnerEntityCollection.getInstance(BusinessPartnerListActivity.this);
        try {
            bpCollection.flush(flushListener);
        } catch (OfflineGenericException e) {
            onODataRequestError(ODataOperation.Flush.getValue(), e);
        }


    }
}
