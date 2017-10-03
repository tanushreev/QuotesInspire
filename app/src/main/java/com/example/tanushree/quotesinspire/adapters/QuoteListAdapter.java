package com.example.tanushree.quotesinspire.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tanushree.quotesinspire.R;
import com.example.tanushree.quotesinspire.controller.QuoteListFragment;
import com.example.tanushree.quotesinspire.model.Quote;

import java.util.List;

/**
 * Created by tanushree on 18/04/16.
 */
public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.QuoteListViewHolder>
{
    private List<Quote> mQuoteList;
    private final QuoteListFragment.OnQuoteSelectedInterface mQuoteActivityReference;

    public QuoteListAdapter(List<Quote> quoteList, QuoteListFragment.OnQuoteSelectedInterface quoteActivityReference)
    {
        mQuoteList = quoteList;
        mQuoteActivityReference = quoteActivityReference;
    }

    // Called when the RecyclerView needs a new ViewHolder.
    @Override
    public QuoteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quote_list_item, parent, false);
        QuoteListViewHolder viewHolder = new QuoteListViewHolder(view, parent.getContext());
        return viewHolder;
    }

    // Called by RecyclerView to display data. RecyclerView will pass a ViewHolder into this method
    // along with the position.
    // int position : The position of the item within the adapter's data set.
    @Override
    public void onBindViewHolder(QuoteListViewHolder holder, int position) {
        holder.bindQuoteTitle(mQuoteList.get(position));
    }

    // RecyclerView asks how many objects are in the list by calling the adapter's getItemCount()
    // method. getItemCount() returns the total number of items in the data set.
    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    //viewholder as inner class.
    public class QuoteListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView mTitleView;
        public Context mContext;
        private Quote mQuote;

        public QuoteListViewHolder(View itemView, Context context) {
            super(itemView);
            mTitleView = (TextView) itemView.findViewById(R.id.tvQuoteItem);
            mContext = context;
            //set this onclicklistener on itemview.
            itemView.setOnClickListener(this);
        }

        public void bindQuoteTitle(Quote quote)
        {
            mQuote = quote;
            mTitleView.setText(quote.getTitle());
        }

        @Override
        public void onClick(View v) {
            mQuoteActivityReference.onQuoteSelected(mQuote.getId());
        }
    }
}


