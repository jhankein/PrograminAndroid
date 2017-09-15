package com.example.saaibi.parcial.Controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.saaibi.parcial.Domain.Event;
import com.example.saaibi.parcial.Repository.EventContract;
import com.example.saaibi.parcial.Repository.EventDbHelper;

import java.util.ArrayList;


/**
 * Created by SAAIBI on 13/9/2017.
 */

public class EventController extends EventDbHelper {

    public EventController(Context context) {super(context);}

    public boolean create(Event event) {
        System.out.println("Event: " + event.toContentValues());

        SQLiteDatabase db = this.getWritableDatabase();
        boolean isCreate = db.insert(EventContract.EventEntry.TABLE_NAME, null, event.toContentValues()) > 0;
        db.close();
        return isCreate ;
    }

    public Cursor getAllEvents() {
        return getReadableDatabase()
                .query(
                        EventContract.EventEntry.TABLE_NAME, null, null, null, null, null, null);
    }

    public boolean dropTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,2);
        return true;
    }
}
