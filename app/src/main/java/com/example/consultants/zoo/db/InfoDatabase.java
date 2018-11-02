package com.example.consultants.zoo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.consultants.zoo.model.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoDatabase extends SQLiteOpenHelper {
    private static final String TAG = InfoDatabase.class.getSimpleName() + "_tag";

    public InfoDatabase(@Nullable Context context) {
        super(context, Contract.NAME, null, Contract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Contract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Contract.DELETE_TABLE);
        onCreate(db);
    }

    public void saveInfo(List<Animal> animalList) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Log.d(TAG, "saveInfo: "+animalList);
        for (int i = 0; i < animalList.size(); i++) {
            contentValues.put(Contract.FeedEntry.COL_CLAS, animalList.get(i).getCategory());
            contentValues.put(Contract.FeedEntry.COL_TYPEOFANIMAL, animalList.get(i).getTypeOfAnimal());
            contentValues.put(Contract.FeedEntry.COL_WEIGHT, animalList.get(i).getWeight());
            contentValues.put(Contract.FeedEntry.COL_SOUND, animalList.get(i).getSound());
            contentValues.put(Contract.FeedEntry.COL_IMAGE, animalList.get(i).getImage());
            contentValues.put(Contract.FeedEntry.COL_NAME, animalList.get(i).getName());
            contentValues.put(Contract.FeedEntry.COL_DETAIL, animalList.get(i).getDetail());
            db.insert(Contract.FeedEntry.TABLE_NAME, null, contentValues);
            Log.d(TAG, "saveInfo: row created");
        }
    }

    public List<Animal> showTable() {
        SQLiteDatabase db = getWritableDatabase();
        List<Animal> infoImageList = new ArrayList<>();

        Cursor cursor = db.rawQuery(Contract.GET_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                Animal animal = new Animal(cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_CLAS)),
                        cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_TYPEOFANIMAL)),
                        cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_WEIGHT)),
                        cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_SOUND)),
                        cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_DETAIL)),
                        cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_NAME)),
                        cursor.getBlob(cursor.getColumnIndex(Contract.FeedEntry.COL_IMAGE)));

                infoImageList.add(animal);
            } while (cursor.moveToNext());
        }
        return infoImageList;
    }

    public HashMap<String, Integer> showCategories() {
        SQLiteDatabase db = getWritableDatabase();

        HashMap<String, Integer> map = new HashMap<>();

        Cursor cursor = db.rawQuery(Contract.GET_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                map.put(cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_CLAS)), 0);
            } while (cursor.moveToNext());
        }
        //Log.d(TAG, "showCategories: HASH" +map);
        return map;
    }


    public List<Animal> showAnimal() {
        List<Animal> animalList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(Contract.GET_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                Animal animal = new Animal(cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_WEIGHT)),
                        cursor.getString(cursor.getColumnIndex(Contract.FeedEntry.COL_NAME)));
                animalList.add(animal);
            } while (cursor.moveToNext());
        }

        return animalList;
    }
}
