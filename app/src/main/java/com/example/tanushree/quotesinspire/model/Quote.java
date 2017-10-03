package com.example.tanushree.quotesinspire.model;

/**
 * Created by tanushree on 18/04/16.
 */
public class Quote
{
    private int mId;
    private String mQuotation;
    private String mTitle;

    public Quote(int id, String quotation, String title)
    {
        mId = id;
        mQuotation = quotation;
        mTitle = title;
    }

    public int getId()
    {
        return mId;
    }

    public String getQuotation()
    {
        return mQuotation;
    }

    public void setQuotation(String quotation)
    {
        mQuotation = quotation;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}