package com.example.tanushree.quotesinspire.controller;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tanushree.quotesinspire.R;

// Important: Regular Fragments should be paired with the Activity class and support Fragments
// should be paired with AppCompatActivity class.


public class QuoteActivity extends AppCompatActivity implements QuoteListFragment.OnQuoteSelectedInterface
{
    public static final String QUOTELIST_FRAGMENT = "quoteList_fragment";
    public static final String QUOTEVIEWPAGER_FRAGMENT = "quoteViewPager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        // Android restores our fragments automatically when we rotate the app. And that results in
        // multiple fragments being created. To solve that problem we do the following.

        QuoteListFragment savedFragment = (QuoteListFragment) getSupportFragmentManager()
                .findFragmentByTag(QUOTELIST_FRAGMENT);

        if(savedFragment == null)
        {
            QuoteListFragment fragment = new QuoteListFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            //add the QuoteListFragment.
            ft.add(R.id.flPaceHolder, fragment, QUOTELIST_FRAGMENT);
            //any changes won't be made permanent until there's a call to commit.
            ft.commit();
        }
    }

    @Override
    public void onQuoteSelected(int id) {
        //Toast.makeText(QuoteActivity.this, string, Toast.LENGTH_SHORT).show(); delete this later.

        QuoteViewPagerFragment fragment = new QuoteViewPagerFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(QuoteViewPagerFragment.KEY_QUOTATION_ID, id);
        fragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.flPaceHolder, fragment, QUOTEVIEWPAGER_FRAGMENT);
        // add this FragmentTransaction to the back stack. This means that the transaction will be
        // remembered after it is committed.
        ft.addToBackStack(null);
        //any changes won't be made permanent until there's a call to commit.
        ft.commit();
    }
}
