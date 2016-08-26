package com.virtualsiamu.rms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 8/26/2016 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    //for identity & corrected
    public static final String identityTABLE_name = "identityTABLE";
    public static final String correctIDTABLE_name = "correctIDTABLE";
    public static final String column_id = "_id";
    public static final String column_UserID = "UserID";
    public static final String column_CorrectID = "CorrectID";


    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();

    }   // Constructor

    //Add Value to identity
    public long addIdentity(String strUserID) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_UserID, strUserID);

        return writeSqLiteDatabase.insert(identityTABLE_name, null, contentValues);
    }

    public long addCorrectID(String strCorrectID) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_CorrectID, strCorrectID);

        return writeSqLiteDatabase.insert(correctIDTABLE_name, null, contentValues);
    }

}   // Main Class
