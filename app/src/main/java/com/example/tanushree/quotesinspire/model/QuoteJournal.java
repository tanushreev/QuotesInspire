package com.example.tanushree.quotesinspire.model;

import android.content.Context;

import com.example.tanushree.quotesinspire.database.QuotesDataSource;

import java.util.List;

/**
 * Created by Tanushree on 25/04/16.
 * We are going to store the List of quotes in a singleton (class).
 * A singleton is a class that allows only one instance of itself to be created.
 */

public class QuoteJournal {
    private static QuoteJournal sQuoteJournal;

    private List<Quote> mQuoteList;

    //private constructor. can be called within the class only.
    private QuoteJournal(Context context)
    {
        //populate the list from the database.
        QuotesDataSource dataSource = new QuotesDataSource(context);
        mQuoteList = dataSource.read();
    }

    public static QuoteJournal get(Context context)
    {
        if (sQuoteJournal == null)
            sQuoteJournal = new QuoteJournal(context);

        return sQuoteJournal;
    }

    public List<Quote> getQuoteList()
    {
        return mQuoteList;
    }
}
