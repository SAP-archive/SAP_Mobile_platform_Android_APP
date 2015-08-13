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
import com.sap.epm.odata.OfflineGenericException;
import com.sap.epm.odata.OfflineRequestListener;
import com.sap.epm.odata.SalesOrderItemEntityCollection;
import com.sap.epm.types.ODataOperation;

public class SalesOrderItemsListActivity extends Activity implements UIListener{
    public static final String TAG = SalesOrderItemsListActivity.class.getSimpleName();
    public String fkId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_items_list);

        Intent intent = getIntent();
        fkId = intent.getExtras().getString("fkId");

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
            OfflineRequestListener requestListener = new OfflineRequestListener(ODataOperation.GetSalesOrdersItems.getValue(), this);
            SalesOrderItemEntityCollection soItemsCollection = SalesOrderItemEntityCollection.getInstance();
            soItemsCollection.findAll(fkId, requestListener);
        } catch (OfflineGenericException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sales_order_items_list, menu);
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

    @Override
    public void onODataRequestError(int operation, Exception e) {

    }

    @Override
    public void onODataRequestSuccess(int operation, String key) {
        LayoutInflater inflater = LayoutInflater.from(SalesOrderItemsListActivity.this);
        SalesOrderItemEntityCollection soItemsCollection = SalesOrderItemEntityCollection.getInstance();

        SalesOrderItemsListAdapter adapter2 = new SalesOrderItemsListAdapter(inflater, this, soItemsCollection.getSalesOrderItems());
        ListView lv = (ListView) findViewById(R.id.lvSalesOrderItems);
        lv.setAdapter(adapter2);
        Toast.makeText(this, getString(R.string.msg_getbp_success), Toast.LENGTH_SHORT).show();

    }
}
