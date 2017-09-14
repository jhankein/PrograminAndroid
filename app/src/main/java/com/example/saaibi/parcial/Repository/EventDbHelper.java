package com.example.saaibi.parcial.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SAAIBI on 13/9/2017.
 */

public class EventDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ParcialPM.db";

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + EventContract.EventEntry.TABLE_NAME + " ("
                + "id" + " PRIMARY KEY NOT NULL,"
                + EventContract.EventEntry.NAME_EVENT + " TEXT NOT NULL,"
                + EventContract.EventEntry.TIPE_EVENT + " TEXT NOT NULL,"
                + EventContract.EventEntry.ATTEN_EVENT + " TEXT NOT NULL,"
                + EventContract.EventEntry.CITY_EVENT + " TEXT NOT NULL,"
                + EventContract.EventEntry.DATE_EVENT + " INT NOT NULL)"
                + EventContract.EventEntry.HOUR_EVENT + " INT NOT NULL)"
                + EventContract.EventEntry.REQUIREMENT_EVENT + " INT NOT NULL)"
                + EventContract.EventEntry.DESCRIPTION_EVENT + " INT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + EventContract.EventEntry.TABLE_NAME );
        onCreate(db);
    }
}
