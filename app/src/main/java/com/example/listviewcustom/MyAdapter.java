package com.example.listviewcustom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<Province> {
    Activity context;
    int idLayout;
    ArrayList<Province> myList;

    public MyAdapter(Activity context1, int idLayout, ArrayList<Province> myList) {
        super(context1, idLayout, myList);
        this.context = context1;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Tạo đế chứa Layout
        LayoutInflater myFlater = context.getLayoutInflater();

        //Đặt ID layout lên để tạo thành view
        convertView = myFlater.inflate(idLayout, null);

        //Lấy 1 phần tử trong mảng
        Province province = myList.get(position);

        //Khai báo, tham chiếu id và hiển thị ảnh lên ImageView
        ImageView imageView = convertView.findViewById(R.id.imgView);
        imageView.setImageResource(province.getId());

        //Khai báo, tham chiếu id và hiển thị tên Tỉnh lên TextField
        TextView textView = convertView.findViewById(R.id.txtView);
        textView.setText(province.getName());

        return convertView;
    }
}
