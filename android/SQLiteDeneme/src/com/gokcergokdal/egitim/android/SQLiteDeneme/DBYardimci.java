package com.gokcergokdal.egitim.android.SQLiteDeneme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by arge on 04.05.2014.
 */
public class DBYardimci extends SQLiteOpenHelper {
    public DBYardimci(Context context) {
        super(context, "veritabani.sqlite", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Veritabanı oluşturma
        Log.d("DBYardimci","Veritabanı ilklendiriliyor..");

        db.execSQL("CREATE TABLE kisi(id INTEGER PRIMARY KEY,ad TEXT, soyad TEXT, yas INTEGER)");
        db.execSQL("INSERT INTO kisi (ad,soyad,yas) VALUES ('John','Due',30)");
        db.execSQL("INSERT INTO kisi (ad,soyad,yas) VALUES ('Jane','Due',25)");

        Log.d("DBYardimci","Veritabanı ilklendirildi");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion<2) {
            db.execSQL("ALTER TABLE kisi ADD COLUMN parola TEXT DEFAULT '-'");
            Log.d("DBYardimci","Veritabanı versiyonu 2'ye yükseltildi.");
//            oldVersion=2;
        }
//        if (oldVersion<3) {
//            // upgrade kodu 2 -> 3
//        }
//        if (oldVersion<4) {
//            // upgrade kodu 3 -> 4
//        }
    }
}
