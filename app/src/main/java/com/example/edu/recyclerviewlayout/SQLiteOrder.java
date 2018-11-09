package com.example.edu.recyclerviewlayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteOrder extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ORDERED.db";
    private static  final  int DATABASE_VESION=1;

    public SQLiteOrder(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE myorder (count text, date text);");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        for(int i=0; i<8; i++) {
            String ordered_date = format.format(new Date());
            String j = String.valueOf(i);
            String q = "INSERT INTO myorder VALUES ('" + j + "','" + ordered_date + "')";
            db.execSQL(q);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myorder");
        onCreate(db);

    }
}
