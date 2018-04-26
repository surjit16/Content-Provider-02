package com.example.surjit.cacaca2;


import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    String stringArray = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dothis(View v) {
        Uri uri = Uri.parse("content://com.example.contentproviderCACA.myprovider/info");
        ContentProviderClient cpc = getContentResolver().acquireContentProviderClient(uri);
        Cursor cr;
        try {
            cr = cpc.query(uri, null, null, null, "name");
            int i=1;
            stringArray = "";
            while (cr.moveToNext()) {
                stringArray += cr.getString(0)+"\n";
            }

            alertDialogBoxSelectItems(v);
        } catch (Exception e) {
        }
    }

    AlertDialog.Builder alertDialog;
    public void alertDialogBoxSelectItems(View view) {

        alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Name's are");

        alertDialog.setMessage(stringArray);

        alertDialog.show();
    }
}
