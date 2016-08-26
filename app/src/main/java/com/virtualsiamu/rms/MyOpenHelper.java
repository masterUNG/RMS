package com.virtualsiamu.rms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 8/26/2016 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name = "rms.db";
    private static final int database_version = 1;

    //for identityTABLE
    private static final String create_identityTABLE = "create table identityTABLE (" +
            "_id integer primary key, " +
            "UserID text);";

    private static final String create_CorrectID = "create table correctIDTABLE (" +
            "_id integer primary key, " +
            "CorrectID text);";



    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_identityTABLE);
        sqLiteDatabase.execSQL(create_CorrectID);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
