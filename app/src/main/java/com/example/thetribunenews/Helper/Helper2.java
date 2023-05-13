package com.example.thetribunenews.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper2 extends SQLiteOpenHelper {
    private static final String dbname = "signregis";
    private static final int version = 1;

    public Helper2(Context context) {
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

    public boolean createuserSign(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserName", username);
        values.put("Email", email);
        values.put("Password", password);

        long r = db.insert("student_record", null, values);
        if (r == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean check_email(String email) {

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from student_record where Email=?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkemailandpassword(String email, String password) {

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from student_record where Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }
}
