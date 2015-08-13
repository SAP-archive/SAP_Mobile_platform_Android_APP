package com.sap.epm.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sap.epm.R;
import com.sap.epm.odata.OfflineGenericException;
import com.sap.epm.odata.OfflineStoreListener;
import com.sap.epm.odata.EntityCollection;
import com.sap.epm.types.ODataOperation;


public class CentralActivity extends Activity implements UIListener{
    private static final String TAG = CentralActivity.class.getSimpleName();

    private ProgressDialog mProgressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        synchronize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_central, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Open the offline store
     */
    private void synchronize() {
        mProgressdialog =
                ProgressDialog.show(CentralActivity.this,
                         "",
                       getString(R.string.prg_sync),
                        true);

        if (!EntityCollection.isOfflineStoreOpen()) {
            try {
                OfflineStoreListener storeListener = new OfflineStoreListener(ODataOperation.OpenOfflineStore.getValue(), this);
                EntityCollection.openOfflineStore(this, storeListener);

            } catch (OfflineGenericException e) {
                Log.e(TAG, "synchronize", e);
            }
        } else {
            mProgressdialog.dismiss();
            goToMainPage();

        }

    }

    @Override
    public void onODataRequestError(int operation, Exception e) {
        mProgressdialog.dismiss();
        Toast.makeText(this, getString(R.string.msg_sync_fail),Toast.LENGTH_SHORT).show();
        goToMainPage();
    }

    @Override
    public void onODataRequestSuccess(int operation, String key) {
        mProgressdialog.dismiss();
        if (EntityCollection.isOfflineStoreOpen()) {
            Toast.makeText(this, R.string.msg_sync_success, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.msg_sync_fail),Toast.LENGTH_SHORT).show();
        }
        goToMainPage();
    }

    private void goToMainPage(){
        Intent goToNextActivity = new Intent(CentralActivity.this,
                BusinessPartnerListActivity.class);
        startActivity(goToNextActivity);
        finish();
    }

}
