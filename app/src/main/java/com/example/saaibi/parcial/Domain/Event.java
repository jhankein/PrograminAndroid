package com.example.saaibi.parcial.Domain;

import android.content.ContentValues;
import android.database.Cursor;


import com.example.saaibi.parcial.Repository.EventContract;

import java.util.Date;

/**
 * Created by SAAIBI on 13/9/2017.
 */

public class Event {

    public   String nameEvent;
    public   String tipeEvent;
    public   String attenEvent;
    public   String cityEvent;
    public   String dateEvent;
    public   String hourEvent;
    public   String requirementEvent;
    public   String descriptionEvent;

    public Event(String nameEvent, String tipeEvent, String attenEvent, String cityEvent, String dateEvent, String hourEvent, String requirementEvent, String descriptionEvent) {

        this.nameEvent = nameEvent;
        this.tipeEvent = tipeEvent;
        this.attenEvent = attenEvent;
        this.cityEvent = cityEvent;
        this.dateEvent = dateEvent;
        this.hourEvent = hourEvent;
        this.requirementEvent = requirementEvent;
        this.descriptionEvent = descriptionEvent;

    }
    public Event (Cursor cursor) {
        nameEvent = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.NAME_EVENT  ));
        tipeEvent = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.TIPE_EVENT));
        attenEvent = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.ATTEN_EVENT));
        cityEvent = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.CITY_EVENT));
        dateEvent = cursor.getString(cursor.getColumnIndexOrThrow(EventContract.EventEntry.DATE_EVENT));
        hourEvent = cursor.getString(cursor.getColumnIndexOrThrow(EventContract.EventEntry.HOUR_EVENT));
        requirementEvent = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.REQUIREMENT_EVENT));
        descriptionEvent = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.DESCRIPTION_EVENT));
    }


    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(EventContract.EventEntry.NAME_EVENT, getNameEvent());
        values.put(EventContract.EventEntry.TIPE_EVENT, getTipeEvent());
        values.put(EventContract.EventEntry.ATTEN_EVENT, getAttenEvent());
        values.put(EventContract.EventEntry.CITY_EVENT, getCityEvent());
        values.put(EventContract.EventEntry.DATE_EVENT, getDateEvent());
        values.put(EventContract.EventEntry.HOUR_EVENT, getHourEvent());
        values.put(EventContract.EventEntry.REQUIREMENT_EVENT, getRequirementEvent());
        values.put(EventContract.EventEntry.DESCRIPTION_EVENT, getDescriptionEvent());
        return values;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getTipeEvent() {
        return tipeEvent;
    }

    public void setTipeEvent(String tipeEvent) {
        this.tipeEvent = tipeEvent;
    }

    public String getAttenEvent() {
        return attenEvent;
    }

    public void setAttenEvent(String attenEvent) {
        this.attenEvent = attenEvent;
    }

    public String getCityEvent() {
        return cityEvent;
    }

    public void setCityEvent(String cityEvent) {
        this.cityEvent = cityEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getHourEvent() {
        return hourEvent;
    }

    public void setHourEvent(String hourEvent) {
        this.hourEvent = hourEvent;
    }

    public String getRequirementEvent() {
        return requirementEvent;
    }

    public void setRequirementEvent(String requirementEvent) {
        this.requirementEvent = requirementEvent;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }
}
