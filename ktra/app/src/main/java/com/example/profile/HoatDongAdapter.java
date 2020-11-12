package com.example.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HoatDongAdapter extends BaseAdapter {
    MainActivity context;
    int myLayout;
    List<HoatDong> hoatDongList;


    public HoatDongAdapter(MainActivity context, int myLayout, List<HoatDong> hoatDongList) {
        this.context = context;
        this.myLayout = myLayout;
        this.hoatDongList = hoatDongList;
    }

    @Override
    public int getCount() {
        return hoatDongList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView=inflater.inflate(myLayout,null);
        //ánh xạ và gán giá trị
        ImageView imgIconHD=convertView.findViewById(R.id.imgIcon);
        imgIconHD.setImageResource(hoatDongList.get(position).getHinhAnh());
        TextView txtTenHD=convertView.findViewById(R.id.txtName);
        txtTenHD.setText(hoatDongList.get(position).getName());
        ImageView imgXoa=convertView.findViewById(R.id.imgXoa);
        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialogXoa(position);
            }
        });
        return convertView;
    }
}
