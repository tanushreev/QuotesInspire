package com.example.tanushree.quotesinspire.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanushree.quotesinspire.R;
import com.example.tanushree.quotesinspire.model.Quote;
import com.example.tanushree.quotesinspire.model.QuoteJournal;

import java.util.List;

/**
 * Created by tanushree on 19/04/16.
 */
public class QuoteViewPagerFragment extends Fragment
{

    public static final String KEY_QUOTATION_ID = "quotation_id";
    public static final String KEY_QUOTATION = "key_quotation";
    List<Quote> mQuoteList;

    // Note: Avoid non-default constructors in Fragments.

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //this is the id of the quotation clicked.
        int id = getArguments().getInt(KEY_QUOTATION_ID);

        View view = inflater.inflate(R.layout.fragment_viewpager_quote, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpQuoteViewPager);

        //read from the database.
        mQuoteList = QuoteJournal.get(this.getActivity()).getQuoteList();



        // Adapter.
        // getChildFragmentManager() returns a private FragmentManager for placing and managing
        // Fragments inside of this Fragment.
        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position)
            {
                Quote quote = mQuoteList.get(position);
                QuotationFragment fragment = new QuotationFragment();
                Bundle bundle = new Bundle();
                bundle.putString(KEY_QUOTATION, quote.getQuotation());
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return mQuoteList.size();
            }
        });

        for(int i = 0; i < mQuoteList.size(); i++)
        {
            if (mQuoteList.get(i).getId() == id) {
                viewPager.setCurrentItem(i);
                break;
            }
        }

        return view;
    }
}
