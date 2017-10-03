package com.example.tanushree.quotesinspire.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by tanushree on 18/04/16.
 */

public class QuotesDatabaseHelper extends SQLiteOpenHelper {

    //.db is required at the end as extension of a SQLite database.
    public static final String DB_NAME = "quotesDatabase.db";
    public static final int DB_VERSION = 1;

    //Quotes Table
    public static final String TABLE_NAME = "QuotesTable";
    public static final String COL_1 = "Quotation";
    public static final String COL_2 = "Title";
    //Create Table QuotesTable (_id Integer Primary Key Autoincrement, Quotation Text, Title Text);
    private static final String CREATE_TABLE_QUERY = "Create Table " + TABLE_NAME + " (" +
            BaseColumns._ID + " Integer Primary Key Autoincrement, " +
            COL_1 + " TEXT, " +
            COL_2 + " TEXT)";

    private static final String INSERT_QUERY1 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('There is a crack in everything. That is how the light gets in.', 'There is a')";
    private static final String INSERT_QUERY2 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('Problems are not stop signs. They are guidelines.', 'Problems are not')";
    private static final String INSERT_QUERY3 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('Magic is believing in yourself. If you can do that, you can make anything happen.', 'Magic is believing')";
    private static final String INSERT_QUERY4 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('Always find time for the things that make you feel happy to be alive.', 'Always find time')";
    private static final String INSERT_QUERY5 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('When we put God first, all other things fall into their proper place.', 'When we put')";
    private static final String INSERT_QUERY6 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('Done is better than perfect.', 'Done is better')";
    private static final String INSERT_QUERY7 = "Insert into " + TABLE_NAME + "(" + COL_1 + ", " + COL_2 + ") " + " values('If you are persistent, you will get it. If you are consistent, you will keep it.', 'If you are')";

    public QuotesDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_QUERY);
        db.execSQL(INSERT_QUERY1);
        db.execSQL(INSERT_QUERY2);
        db.execSQL(INSERT_QUERY3);
        db.execSQL(INSERT_QUERY4);
        db.execSQL(INSERT_QUERY5);
        db.execSQL(INSERT_QUERY6);
        db.execSQL(INSERT_QUERY7);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
