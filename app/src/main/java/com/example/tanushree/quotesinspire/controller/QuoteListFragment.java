package com.example.tanushree.quotesinspire.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanushree.quotesinspire.R;
import com.example.tanushree.quotesinspire.adapters.QuoteListAdapter;
import com.example.tanushree.quotesinspire.database.QuotesDataSource;
import com.example.tanushree.quotesinspire.model.Quote;
import com.example.tanushree.quotesinspire.model.QuoteJournal;

import java.util.List;

/**
 * Created by tanushree on 18/04/16.
 */

//extend the support version of the Fragment class.
public class QuoteListFragment extends Fragment
{
    //inner interface.
    public interface OnQuoteSelectedInterface
    {
        void onQuoteSelected(int id);
    }

    RecyclerView mQuoteListRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_quote, container, false);
        mQuoteListRecyclerView = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        OnQuoteSelectedInterface quoteActivityReference = (OnQuoteSelectedInterface) getActivity();

        //QuotesDataSource dataSource = new QuotesDataSource(this.getActivity());
        //dataSource.create();
        //read from the database.
        //ArrayList<Quote> quoteList = dataSource.read();
        List<Quote> quoteList = QuoteJournal.get(this.getActivity()).getQuoteList();
        QuoteListAdapter adapter = new QuoteListAdapter(quoteList, quoteActivityReference);
        mQuoteListRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mQuoteListRecyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
