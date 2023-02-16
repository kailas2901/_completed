package com.example.currency_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    DBHelper dbhelper;
    SQLiteDatabase database;
    Context context;

    public DBManager (Context c){
        context = c;
    }
    public DBManager Open() {
        dbhelper = new DBHelper(context);
        database = dbhelper.getReadableDatabase();
        return this;
    }
    public void Close(){
        dbhelper.close();
    }
    public void Insert(String country,String currency){
        ContentValues values = new ContentValues();
        values.put(dbhelper._NAME,country);
        values.put(dbhelper._CURRENCY,currency);

        database.insert(dbhelper.TABLE_NAME,null,values);

    }

}

