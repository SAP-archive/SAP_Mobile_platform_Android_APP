package com.sap.epm.app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sap.epm.R;
import com.sap.epm.mbo.SalesOrder;
import com.sap.epm.mbo.SalesOrderItems;

import java.util.ArrayList;


/**
 * Business partners list adapter
 *
 */
public class SalesOrderItemsListAdapter extends BaseAdapter{
    public static final String TAG = SalesOrderItemsListAdapter.class.getSimpleName();

    final private LayoutInflater inflater;
    final private ArrayList<SalesOrderItems> salesOrderItems;
    final private SalesOrderItemsListActivity activity;


    public SalesOrderItemsListAdapter(LayoutInflater inflater, SalesOrderItemsListActivity activity, ArrayList<SalesOrderItems> salesOrdersItems) {
        this.inflater = inflater;
        this.activity = activity;
        this.salesOrderItems = salesOrdersItems;
//        this.myList = myList;
    }

    @Override
    public int getCount() {
        int size = (salesOrderItems!=null)?salesOrderItems.size():0;
        Log.d(TAG, "getCount: "+size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.d(TAG, "getItem: "+position);
        return (salesOrderItems!=null)?salesOrderItems.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        Log.d(TAG, "getItemId: "+position);
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView");
        TextView tv = null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.salesorderitems_view, parent, false);
        }

        SalesOrderItems soItems =  salesOrderItems.get(position);

        tv = (TextView)convertView.findViewById(R.id.tvSOItemID);
        tv.setText(soItems.getSO_ID());

        tv = (TextView)convertView.findViewById(R.id.tvSOItemPos);
        tv.setText(soItems.getNOTE());
        return convertView;
    }
}
