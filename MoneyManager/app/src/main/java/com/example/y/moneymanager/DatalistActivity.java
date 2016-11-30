package com.example.y.moneymanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DatalistActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbhelper userDbhelper;
    Cursor cursor;
    Listdataadapter listdataadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datalist);
        listView = (ListView) findViewById(R.id.lv_listview);
        listdataadapter = new Listdataadapter(getApplicationContext(),R.layout.row_view);
        listView.setAdapter(listdataadapter);
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getReadableDatabase();
        cursor = userDbhelper.getinformaton(sqLiteDatabase);

        if (cursor.moveToFirst()) {

            do {
                String month,week,date,category,amount;
                month = cursor.getString(0);
                week = cursor.getString(1);
                date = cursor.getString(2);
                category = cursor.getString(3);
                amount = cursor.getString(4);
                Dataprovider dataprovider = new Dataprovider(month,week,date,category,amount);
                listdataadapter.add(dataprovider);

            } while (cursor.moveToNext());


        }





    }





}
