package com.example.home_pc.mydatadeleter;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.home_pc.mydatadeleter.MainActivity.CONTACTS;

public class ShowContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);

        ArrayList<Contact> contacts = (ArrayList<Contact>) getIntent().getSerializableExtra(CONTACTS);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecViewAdapter adapter = new RecViewAdapter(this, contacts);
        recyclerView.setAdapter(adapter);

    }
}
