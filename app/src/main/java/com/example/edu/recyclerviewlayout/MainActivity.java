package com.example.edu.recyclerviewlayout;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    FloatingActionButton floatingActionButton;
    SQLiteDatabase mdb;
    SQLiteOrder dbHelper;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new SQLiteOrder(this);
        mdb=dbHelper.getWritableDatabase();
        adapter = new RecyclerAdapter(mdb);

        ArrayList<HashMap<String, Object>> arrayList=new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object> hashMap=null;
        hashMap=new HashMap<String, Object>();
        hashMap.put("title","Chapter One");
        hashMap.put("detail","Item one detail");

        hashMap.put("image",R.drawable.android_image_1);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Two");
        hashMap.put("detail","Item two detail");
        hashMap.put("image",R.drawable.android_image_2);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Three");
        hashMap.put("detail","Item three detail");
        hashMap.put("image",R.drawable.android_image_3);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Four");
        hashMap.put("detail","Item four detail");
        hashMap.put("image",R.drawable.android_image_4);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Five");
        hashMap.put("detail","Item five detail");
        hashMap.put("image",R.drawable.android_image_5);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Six");
        hashMap.put("detail","Item six detail");
        hashMap.put("image",R.drawable.android_image_6);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Seven");
        hashMap.put("detail","Item seven detail");
        hashMap.put("image",R.drawable.android_image_7);
        arrayList.add(hashMap);

        hashMap=null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title","Chapter Eight");
        hashMap.put("detail","Item eight detail");
        hashMap.put("image",R.drawable.android_image_8);
        arrayList.add(hashMap);

        floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                int[] image={R.drawable.android_image_1,R.drawable.android_image_2,R.drawable.android_image_3,R.drawable.android_image_4,
                        R.drawable.android_image_5,R.drawable.android_image_6,R.drawable.android_image_7,R.drawable.android_image_8};

                HashMap<String, Object> hashMap1=new HashMap<String, Object>();
                hashMap1.put("title", "Chpter N+1");

                hashMap1.put("image", image[count]);
                count+=1;
                adapter.addItem(1, hashMap1);;
            }
        });

        recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //adapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
