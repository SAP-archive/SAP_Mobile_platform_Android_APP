package com.sap.epm.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.sap.epm.R;
import com.sap.epm.mbo.BusinessPartner;
import com.sap.epm.odata.BusinessPartnerEntityCollection;
import com.sap.epm.odata.OfflineGenericException;
import com.sap.epm.odata.OfflineRequestListener;
import com.sap.epm.types.ODataOperation;

import java.util.Random;

public class BusinessPartnerActivity extends ActionBarActivity implements UIListener{
    public static final String TAG = BusinessPartnerActivity.class.getSimpleName();

    private EditText childViewAgencyID, childViewAgencyName, childViewURL;
    private EditText childViewStreet, childViewCity, childViewCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_partner_2);

        childViewAgencyID = (EditText) findViewById(R.id.bp_id);
        childViewAgencyName = (EditText) findViewById(R.id.bp_name);
        childViewURL = (EditText) findViewById(R.id.bp_url);
        childViewStreet = (EditText) findViewById(R.id.bp_street);
        childViewCity = (EditText) findViewById(R.id.bp_city);
        childViewCountry = (EditText) findViewById(R.id.bp_country);

        initializeBusinessPartnerId();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_business_partner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item_save) {
            onSaveRequested();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void initializeBusinessPartnerId(){
        Random rand = new Random();;
        int min = 100000000, max = 999999999;

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt(max - min + 1) + min;
        childViewAgencyID.setText(String.valueOf(randomNum));

    }

    public void onSaveRequested() {

        String ID = childViewAgencyID.getText().toString();
        String name = childViewAgencyName.getText().toString();
        String street = childViewStreet.getText().toString();
        String city = childViewCity.getText().toString();
        String country = childViewCountry.getText().toString();
        String webaddress = childViewURL.getText().toString();

        BusinessPartner bp = new BusinessPartner(ID, name, street, city, country, webaddress );
        OfflineRequestListener requestListener = new OfflineRequestListener(ODataOperation.CreateBusinessPartner.getValue(), this);
        BusinessPartnerEntityCollection bpCollection = BusinessPartnerEntityCollection.getInstance(this);
        try {
            bpCollection.create(bp, requestListener);
        } catch (OfflineGenericException e) {
            Log.d(TAG, "onSaveRequested", e);
        }

    }


    @Override
    public void onODataRequestError(int operation, Exception e) {
        Toast.makeText(this, getString(R.string.msg_getbp_success), Toast.LENGTH_SHORT).show();
        goToMainPage();
    }

    @Override
    public void onODataRequestSuccess(int operation, String key) {
        Toast.makeText(this, getString(R.string.msg_getbp_success), Toast.LENGTH_SHORT).show();
        goToMainPage();
    }

    private void goToMainPage(){
        Intent goToNextActivity = new Intent(this,
                BusinessPartnerListActivity.class);
        startActivity(goToNextActivity);
        finish();
    }

}
