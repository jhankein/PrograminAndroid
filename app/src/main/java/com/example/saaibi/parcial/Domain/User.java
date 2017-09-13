package com.example.saaibi.parcial.Domain;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.saaibi.parcial.Repository.UserContract;

/**
 * Created by SAAIBI on 10/9/2017.
 */

public class User {

    private String userName;
    private String name;
    private String lastName;
    private String password;
    private String rol;
    private int age;


    public User(String userName, String name, String lastName, String password, String rol, int age) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.rol = rol;
        this.age = age;
    }

    public User(Cursor cursor) {
        userName = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.USER_NAME));
        name = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.NAME));
        lastName = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.LAST_NAME));
        password = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.PASSWORD));
        rol = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.ROL));
        age = cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.AGE));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME, getUserName());
        values.put(UserContract.UserEntry.NAME, getName());
        values.put(UserContract.UserEntry.LAST_NAME, getLastName());
        values.put(UserContract.UserEntry.PASSWORD, getPassword());
        values.put(UserContract.UserEntry.ROL, getRol());
        values.put(UserContract.UserEntry.AGE, getAge());
        return values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}