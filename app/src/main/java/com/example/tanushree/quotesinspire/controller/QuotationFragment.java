package com.example.tanushree.quotesinspire.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tanushree.quotesinspire.R;

/**
 * Created by tanushree on 25/04/16.
 */
public class QuotationFragment extends Fragment
{
    private TextView mQuotationView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String quotation = getArguments().getString(QuoteViewPagerFragment.KEY_QUOTATION);
        View view = inflater.inflate(R.layout.fragment_quotation, container, false);
        mQuotationView = (TextView) view.findViewById(R.id.tvQuotation);
        mQuotationView.setText(quotation);
        return view;
    }
}
