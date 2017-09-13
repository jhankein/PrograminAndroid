package com.example.saaibi.parcial.Repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SAAIBI on 10/9/2017.
 */

public class UsersDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ParcialPM.db";

    public UsersDbHelper(Context context ) {super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.USER_NAME + " PRIMARY KEY NOT NULL,"
                + UserContract.UserEntry.NAME + " TEXT NOT NULL,"
                + UserContract.UserEntry.LAST_NAME + " TEXT NOT NULL,"
                + UserContract.UserEntry.PASSWORD + " TEXT NOT NULL,"
                + UserContract.UserEntry.ROL + " TEXT NOT NULL,"
                + UserContract.UserEntry.AGE + " INT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + UserContract.UserEntry.TABLE_NAME);
        onCreate(db);
    }

}
