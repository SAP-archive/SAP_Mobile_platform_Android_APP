package com.sap.epm.app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sap.epm.R;
import com.sap.epm.mbo.BusinessPartner;

import java.util.ArrayList;


/**
 * Business partners list adapter
 *
 */
public class BusinessPartnerListAdapter extends BaseAdapter{
    public static final String TAG = BusinessPartnerListAdapter.class.getSimpleName();

    final private LayoutInflater inflater;
    final private ArrayList<BusinessPartner> businessPartners;
    final private BusinessPartnerListActivity activity;


    public BusinessPartnerListAdapter(LayoutInflater inflater, BusinessPartnerListActivity activity, ArrayList<BusinessPartner> businessPartners) {
        this.inflater = inflater;
        this.activity = activity;
        this.businessPartners = businessPartners;
//        this.myList = myList;
    }

    @Override
    public int getCount() {
        int size = (businessPartners!=null)?businessPartners.size():0;
        Log.d(TAG, "getCount: "+size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.d(TAG, "getItem: "+position);
        return (businessPartners!=null)?businessPartners.get(position):null;
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
            convertView = inflater.inflate(R.layout.businesspartner_view, parent, false);
        }

        BusinessPartner bp =  businessPartners.get(position);

        tv = (TextView)convertView.findViewById(R.id.tvBusinessPartner);
        tv.setText(bp.getCOMPANY_NAME());

        tv = (TextView)convertView.findViewById(R.id.tvURL);
        tv.setText(bp.getWEB_ADDRESS());

        convertView.setOnClickListener(new BusinessPartnerListClickListener(bp));

        return convertView;
    }

    /**
     * This listener handles clicks on a travel agency in the list.
     */
    private class BusinessPartnerListClickListener implements View.OnClickListener {

        final private BusinessPartner item;

        private BusinessPartnerListClickListener(BusinessPartner item) {
            this.item = item;
        }

        @Override
        public void onClick(final View view) {
            activity.onSelectedItem(item.getBP_ID());

        }
    }

}
