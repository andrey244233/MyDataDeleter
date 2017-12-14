package com.example.home_pc.mydatadeleter;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    Cursor cursor;
    private static final int URL_LOADER = 0;
    Loader<Cursor> loaderManager;
    public static final String CONTACTS = "contacts";
    String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
    String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    ArrayList<Contact> contacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDeleteFromOtherApp = findViewById(R.id.btn_delete_from_other_app);
        btnDeleteFromOtherApp.setOnClickListener(this);
        Button btnContacts = findViewById(R.id.btnContacts);
        btnContacts.setOnClickListener(this);

        loaderManager = getLoaderManager().initLoader(URL_LOADER, null, this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnContacts:
                showContacts();
                break;
            case R.id.btn_delete_from_other_app:
                deleteDataFromOtherApp();
                break;
        }
    }

    private void deleteDataFromOtherApp() {
        int deletedRows = getContentResolver().delete(CatsContract.CatsEntry.CONTENT_URI, null, null);
        Log.v("tag", "DELETED ROWS = " + deletedRows);
    }

    private void parseCursor() {
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
//            int number = cursor.getInt(cursor.getColumnIndex(NUMBER));
//            String num = String.valueOf(number);
            contacts.add(new Contact(name, name));
        }
    }

    private void showContacts() {
        Intent intent = new Intent(this, ShowContactsActivity.class);
        intent.putExtra(CONTACTS, contacts);
        startActivity(intent);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String projection[] = {
                ContactsContract.Contacts.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER
        };
        return new CursorLoader(this, ContactsContract.Contacts.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.cursor = cursor;
        parseCursor();
        Log.v("tag", "contacts = " + contacts.size());
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
