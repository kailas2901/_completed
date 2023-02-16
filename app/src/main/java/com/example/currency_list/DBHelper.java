package com.example.currency_list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //contract
    private static final String DB_NAME = "Ddukk-Con.db";
    public static final String TABLE_NAME = "Country";

    public static final String _ID = "id";
    public static final String _NAME = "name";
    public static final String _CURRENCY = "currency";

   private static final int _VERSION = 1;

   private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( "+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ _NAME +"" +
           " TEXT NOT NULL ,"+_CURRENCY +" TEXT);";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, _VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }
}
