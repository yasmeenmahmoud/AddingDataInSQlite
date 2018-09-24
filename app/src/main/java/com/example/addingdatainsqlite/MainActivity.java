package com.example.addingdatainsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Databasehelper mydatabase;
    Button adddata, showcontent;
    EditText myentry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myentry = findViewById(R.id.name);
        adddata = findViewById(R.id.Add_btn);
        mydatabase=new Databasehelper(MainActivity.this);
        showcontent = findViewById(R.id.viewcontent_btn);
        showcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showintent = new Intent(MainActivity.this, viewlistcontent.class);
                startActivity(showintent);
            }
        });
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newentry = myentry.getText().toString();
                if (myentry.length() != 0) {
                    ADDDATA(newentry);
                    myentry.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You Must Add data here..", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ADDDATA(String newEntry) {
        Boolean Data = mydatabase.insertData(newEntry);
        if (Data == true) {
            Toast.makeText(MainActivity.this, "Data Addedd Successfully", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(MainActivity.this, "something wrong ", Toast.LENGTH_LONG).show();
        }

    }

}

