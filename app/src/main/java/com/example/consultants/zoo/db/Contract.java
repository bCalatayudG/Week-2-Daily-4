package com.example.consultants.zoo.db;

import android.provider.BaseColumns;

public class Contract {

    public static final String NAME = "database.db";
    public static final int VERSION = 1;


    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    FeedEntry.TABLE_NAME + "(" +
                    FeedEntry.COL_CLAS + " Text, " +
                    FeedEntry.COL_TYPEOFANIMAL + " Text, " +
                    FeedEntry.COL_NAME + " Text, " +
                    FeedEntry.COL_WEIGHT + " Text, " +
                    FeedEntry.COL_SOUND + " Text, " +
                    FeedEntry.COL_IMAGE + " Text, " +
                    FeedEntry.COL_DETAIL + " Text)";

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "photo";
        public static final String COL_TYPEOFANIMAL = "typeOfAnimal";
        public static final String COL_CLAS = "classOfAnimal";
        public static final String COL_WEIGHT = "weight";
        public static final String COL_SOUND = "sound";
        public static final String COL_IMAGE = "image";
        public static final String COL_NAME = "name";
        public static final String COL_DETAIL = "detail";
    }

    public static final String GET_ALL = "SELECT * FROM " + FeedEntry.TABLE_NAME;

    public static final String GET_CATEGORIES = "SELECT " +FeedEntry.COL_CLAS+ " FROM " + FeedEntry.TABLE_NAME;

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
}
