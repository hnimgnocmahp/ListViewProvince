package com.example.listviewcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int image[] = {
            R.drawable.cantho,
            R.drawable.danang,
            R.drawable.hcm,
            R.drawable.hanoi
    };

    String name[] = {
            "Cần thơ", "Đà Nẵng", "Hồ Chí Minh", "Hà Nội"
    };

    ArrayList<Province> myList;
    MyAdapter myAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            myList.add(new Province(image[i], name[i]));

        }
        myAdapter = new MyAdapter(MainActivity.this, R.layout.layout_item, myList);
        lv.setAdapter(myAdapter);

        //Xử lý click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("name", name[i]);
                startActivity(intent);
            }
        });

    }
}