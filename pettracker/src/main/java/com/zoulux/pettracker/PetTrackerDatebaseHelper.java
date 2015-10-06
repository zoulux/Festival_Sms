package com.zoulux.pettracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zoulux on 2015-09-30 10:43.
 */
public class PetTrackerDatebaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="pet_tracker.db";
    private static final int DATEBASE_VERSION=1;

    public PetTrackerDatebaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATEBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ PetDatebase.PetType.PETTYPE_TABLE_NAME+"("
                        + PetDatebase.PetType._ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                        + PetDatebase.PetType.PET_TYPE_NAME+"TEXT"
                        +");"
        );

        db.execSQL("CREATE TABLE "+ PetDatebase.Pets.PET_TABLE_NAME+"("
                + PetDatebase.Pets._ID+"INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + PetDatebase.Pets.PET_TYPE_ID+""
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
