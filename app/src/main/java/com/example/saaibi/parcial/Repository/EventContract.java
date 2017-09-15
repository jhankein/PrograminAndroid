package com.example.saaibi.parcial.Repository;

import android.provider.BaseColumns;

import java.sql.Date;

/**
 * Created by SAAIBI on 13/9/2017.
 */

public  class EventContract {
    public static abstract class EventEntry implements BaseColumns {
        public static final String TABLE_NAME ="events";

        public static final String _ID = "_id";
        public static final String NAME_EVENT = "nameEvent";
        public static final String TIPE_EVENT = "tipeEvent";
        public static final String ATTEN_EVENT = "attenEvent";
        public static final String CITY_EVENT = "cityEvent";
        public static final String DATE_EVENT = "dateEvent";
        public static final String HOUR_EVENT = "hourEvent";
        public static final String REQUIREMENT_EVENT = "requirementEvent";
        public static final String DESCRIPTION_EVENT = "descriptionEvent";
    }
}
