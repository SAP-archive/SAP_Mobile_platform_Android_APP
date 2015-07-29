package com.sap.epm.app;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.sap.epm.R;
import com.sap.epm.mbo.SalesOrder;
import com.sap.epm.odata.OfflineGenericException;
import com.sap.epm.odata.OfflineRequestListener;
import com.sap.epm.odata.SalesOrderEntityCollection;
import com.sap.epm.types.ODataOperation;

public class SalesOrderListActivity extends ActionBarActivity implements UIListener {
    public static final String TAG = SalesOrderListActivity.class.getSimpleName();
    public String fkId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_list);
        Intent intent = getIntent();
        fkId = intent.getExtras().getString("fkId");

    }


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        refresh();
    }


    private void refresh() {
        Log.d(TAG, "refresh");
        try {
            OfflineRequestListener requestListener = new OfflineRequestListener(ODataOperation.GetSalesOrders.getValue(), this);
            SalesOrderEntityCollection salesOrderCollection = SalesOrderEntityCollection.getInstance();
            salesOrderCollection.findAll(fkId, requestListener);
        } catch (OfflineGenericException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sales_order, menu);
        return true;
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
        Toast.makeText(SalesOrderListActivity.this, getString(R.string.msg_getbp_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onODataRequestSuccess(int operation, String key) {
        SalesOrderEntityCollection salesOrderCollection = SalesOrderEntityCollection.getInstance();
        LayoutInflater inflater = LayoutInflater.from(SalesOrderListActivity.this);


        SalesOrderListAdapter adapter2 = new SalesOrderListAdapter(inflater, SalesOrderListActivity.this, salesOrderCollection.getSalesOrders());

        ListView lv = (ListView) findViewById(R.id.lvSalesOrder);
        lv.setAdapter(adapter2);
        Toast.makeText(SalesOrderListActivity.this, getString(R.string.msg_getbp_success), Toast.LENGTH_SHORT).show();
    }

    public void onSelectedItem(String fkId) {
        Intent i = new Intent(this, SalesOrderItemsListActivity.class);
        i.putExtra("fkId", fkId);
        this.startActivity(i);

    }


}
