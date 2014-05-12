package com.gokcergokdal.egitim.android.SQLiteDeneme;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import com.example.SQLiteDeneme.R;

public class MyActivity extends Activity {

    DBYardimci db;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("MyActivity","Uygulama başladı");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        db = new DBYardimci(this);

        Cursor cursor = db.getReadableDatabase().rawQuery("select ad, soyad, yas from Kisi", null);

        Log.d("MyActivity","Kişiler listeleniyor..");
        while (cursor.moveToNext()) {
            Log.d("MyActivity","Kisi Ad: " + cursor.getString(0));
            Log.d("MyActivity","Kisi Soyad: " + cursor.getString(1));
            Log.d("MyActivity","Kisi Yaş: " + cursor.getInt(2));
        }
        Log.d("MyActivity","Kişiler listelendi.");
    }
}
