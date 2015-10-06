package com.zoulux.zoulux_festival_sms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.zoulux.zoulux_festival_sms.R;
import com.zoulux.zoulux_festival_sms.bean.Festival;
import com.zoulux.zoulux_festival_sms.bean.FestivalLab;

/**
 * Created by Lenovo on 2015-9-29-0029.
 */
public class FestivalCategoryFragment extends Fragment {

    private GridView mGridView;
    private ArrayAdapter<Festival> mAdapter;
    private LayoutInflater mInflater;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            mInflater=inflater;
        return inflater.inflate(R.layout.fragment_festival_category,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridView= (GridView) view.findViewById(R.id.id_gv_festivalCategory);
        mAdapter=new ArrayAdapter<Festival>(getActivity(),-1, FestivalLab.getIntance().getFestivals()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
               if (convertView==null){
                convertView=mInflater.inflate(R.layout.item_festival,parent,false);
               }
                TextView tv= (TextView) convertView.findViewById(R.id.id_tv_festival_name);
                tv.setText(getItem(position).getName());

                return  convertView;

            }
        };
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             // TODO: 2015-10-02 10:56


            }
        });

    }
}
