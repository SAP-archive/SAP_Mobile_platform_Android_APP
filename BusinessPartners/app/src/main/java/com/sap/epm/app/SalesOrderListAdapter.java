package com.sap.epm.app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sap.epm.R;
import com.sap.epm.mbo.BusinessPartner;
import com.sap.epm.mbo.SalesOrder;

import java.util.ArrayList;


/**
 * Business partners list adapter
 *
 */
public class SalesOrderListAdapter extends BaseAdapter{
    public static final String TAG = SalesOrderListAdapter.class.getSimpleName();

    final private LayoutInflater inflater;
    final private SalesOrderListActivity activity;
    final private ArrayList<SalesOrder> salesOrders;


    public SalesOrderListAdapter(LayoutInflater inflater, SalesOrderListActivity activity, ArrayList<SalesOrder> salesOrders) {
        this.inflater = inflater;
        this.activity = activity;
        this.salesOrders = salesOrders;
//        this.myList = myList;
    }

    @Override
    public int getCount() {
        int size = (salesOrders!=null)?salesOrders.size():0;
        Log.d(TAG, "getCount: "+size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.d(TAG, "getItem: "+position);
        return (salesOrders!=null)?salesOrders.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        Log.d(TAG, "getItemId: "+position);
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView");
        TextView tv = null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.salesorder_view, parent, false);
        }

        SalesOrder so =  salesOrders.get(position);

        tv = (TextView)convertView.findViewById(R.id.tvSalesOrder);
        tv.setText(so.getBUYER_NAME());

        tv = (TextView)convertView.findViewById(R.id.tvSalesOrderDetails);
        tv.setText(so.getNOTE());

        convertView.setOnClickListener(new SalesOrderListClickListener(so));

        return convertView;
    }

    /**
     * This listener handles clicks on a travel agency in the list.
     */
    private class SalesOrderListClickListener implements View.OnClickListener {

        final private SalesOrder item;

        private SalesOrderListClickListener(SalesOrder item) {
            this.item = item;
        }

        @Override
        public void onClick(final View view) {
            activity.onSelectedItem(item.getSO_ID());

        }
    }

}
