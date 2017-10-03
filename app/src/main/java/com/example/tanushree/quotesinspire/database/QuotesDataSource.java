package com.example.tanushree.quotesinspire.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.provider.BaseColumns;

import com.example.tanushree.quotesinspire.database.QuotesDatabaseHelper;
import com.example.tanushree.quotesinspire.model.Quote;

import java.util.ArrayList;

/**
 * Created by tanushree on 18/04/16.
 */
public class QuotesDataSource
{
    private Context mContext;
    private QuotesDatabaseHelper mQuotesDatabaseHelper;

    public QuotesDataSource(Context context)
    {
        mContext = context;
        mQuotesDatabaseHelper = new QuotesDatabaseHelper(context);
        SQLiteDatabase database = mQuotesDatabaseHelper.getReadableDatabase();
        database.close();
    }

    private SQLiteDatabase open()
    {
        return mQuotesDatabaseHelper.getWritableDatabase();
    }

    private void close(SQLiteDatabase database)
    {
        database.close();
    }

    //read from the quotes database.
    public ArrayList<Quote> read()
    {
        //open the database.
        SQLiteDatabase database = open();
        //create a cursor object.
        Cursor cursor = database.query(QuotesDatabaseHelper.TABLE_NAME,
                new String[]{BaseColumns._ID, QuotesDatabaseHelper.COL_1, QuotesDatabaseHelper.COL_2},
                null,
                null,
                null,
                null,
                null);

        //create an arraylist of type Quote.
        ArrayList<Quote> quoteList = new ArrayList<Quote>();
        if(cursor.moveToFirst())
        {
            do{
                Quote quote = new Quote(getIntFromColumnName(cursor, BaseColumns._ID),
                        getStringFromColumnName(cursor, QuotesDatabaseHelper.COL_1),
                        getStringFromColumnName(cursor, QuotesDatabaseHelper.COL_2));

                quoteList.add(quote);

            }while(cursor.moveToNext());
        }
        //close the cursor.
        cursor.close();
        //close the database.
        close(database);
        //return the data(arraylist of quotes).
        return quoteList;
    }

    private int getIntFromColumnName(Cursor cursor, String columnName)
    {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getInt(columnIndex);
    }

    private String getStringFromColumnName(Cursor cursor, String columnName)
    {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getString(columnIndex);
    }

    /*public ArrayList<String> read()
    {
        SQLiteDatabase database = open();
        Cursor cursor = database.query(QuotesDatabaseHelper.TABLE_NAME,
                new String[]{QuotesDatabaseHelper.COL_2},
                null,
                null,
                null,
                null,
                null);

        ArrayList<String> titleList = new ArrayList<String>();
        if(cursor.moveToFirst())
        {
            do{
                int columnIndex = cursor.getColumnIndex(QuotesDatabaseHelper.COL_2);
                String string = cursor.getString(columnIndex);
                titleList.add(string);

            }while(cursor.moveToNext());
        }
        cursor.close();
        close(database);
        return titleList;
    }*/

    public void create()
    {
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues quoteContentValues = new ContentValues();
        quoteContentValues.put(QuotesDatabaseHelper.COL_1,
                "Tough times never last but tough people do");
        quoteContentValues.put(QuotesDatabaseHelper.COL_2, "Tough times never");
        long quoteID = database.insert(QuotesDatabaseHelper.TABLE_NAME, null, quoteContentValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
    }
}