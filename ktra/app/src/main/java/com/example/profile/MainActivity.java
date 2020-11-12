package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ListView lvHoatDong;
    ArrayList<HoatDong> hoatDongArrayList;
    HoatDongAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHoatDong();
        lvHoatDong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it= new Intent(MainActivity.this,profilea.class);
                startActivity(it);
            }
        });



    }
    private void  initHoatDong() {
        lvHoatDong=findViewById(R.id.lvHoatDong);
        hoatDongArrayList= new ArrayList<HoatDong>();
        hoatDongArrayList.add(new HoatDong(R.drawable.logo,"Huỳnh Phong Nhã"));
        hoatDongArrayList.add(new HoatDong(R.drawable.logo,"Nhã"));
        hoatDongArrayList.add(new HoatDong(R.drawable.logo,"Nhân"));
        hoatDongArrayList.add(new HoatDong(R.drawable.logo,"Trường"));
         adapter= new HoatDongAdapter(MainActivity.this,R.layout.dong_hoat_dong,hoatDongArrayList);
        lvHoatDong.setAdapter(adapter);
    }
    public void dialogXoa(final int vitri) {
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có chắc chắn xóa không ?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hoatDongArrayList.remove(vitri);
                Toast.makeText(MainActivity.this, "Đã xóa" , Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialogXoa.show();
    }

}