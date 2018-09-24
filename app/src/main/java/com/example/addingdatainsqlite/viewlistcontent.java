package com.example.addingdatainsqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewlistcontent extends AppCompatActivity {
    Databasehelper mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlistcontent);

        ListView mylist = findViewById(R.id.mylistview);
        mydatabase = new Databasehelper(viewlistcontent.this);
        ArrayList<String> myarraylist = new ArrayList();
        Cursor data = mydatabase.getListContent();
        if (data.getCount() == 0) {
            Toast.makeText(viewlistcontent.this, "the database was empty..", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                myarraylist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myarraylist);
                mylist.setAdapter(listAdapter);
            }

        }
    }

}
