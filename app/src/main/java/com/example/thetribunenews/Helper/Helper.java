package com.example.thetribunenews.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    private static final String dbname = "User_registration";
    private static final int version = 1;

    public Helper( Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table student_record (id integer primary key autoincrement , Username text , Email text " +
                ", Password text) ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists student_record");
        onCreate(db);
    }

    public boolean InsertContact(String name,String email,String phonenumber){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("UserName" , name);
        values.put("Email" , email);
        values.put("Password"  , phonenumber);
        long r=db.insert("student_record" , null , values);
        if (r==-1){
            return false;
        }else {
            return true;
        }


    }
}
