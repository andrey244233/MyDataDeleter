package com.example.home_pc.mydatadeleter;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDeleteFromOtherApp = findViewById(R.id.btn_delete_from_other_app);
        btnDeleteFromOtherApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDataFromOtherApp();
            }
        });
    }

    private void deleteDataFromOtherApp() {
        int deletedRows = getContentResolver().delete(CatsContract.CatsEntry.CONTENT_URI, null, null);
        Log.v("tag", "DELETED ROWS = " + deletedRows);
    }
}
