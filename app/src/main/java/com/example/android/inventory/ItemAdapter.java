package com.example.android.inventory;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.inventory.Data.RVCursorAdapter;

//RecyclerView Adapter for Items

private class ItemAdapter extends RVCursorAdapter<ItemHolder> {

    public ItemAdapter() {
        super(null);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_show, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, Cursor cursor) {
        //In my case, I have a MyItem class that models the data in the cursor,
        //so I create a new instance of MyItem, and pass that on
        //to the ViewHolder to be bound and displayed.
        MyItem item = MyItem.getFromCursor(cursor);
        holder.bindItem(item);
    }
    @Override
    public void swapCursor(Cursor newCursor) {
        super.swapCursor(newCursor);

        //I have an text view that gets displayed when there are no
        //items in the list, and this code handles hiding/showing it.
        //Whenever there is a new cursor.
        if (getItemCount() > 0) {
            mEmptyText.setVisibility(View.GONE);
        } else {
            mEmptyText.setVisibility(View.VISIBLE);
        }
    }
}

class ItemHolder extends RecyclerView.ViewHolder {
    private TextView mItemTitle;
    private TextView mRecordings;
    private TextView mCity;
    private TextView mSoundboard;


    public ItemHolder(View itemView) {
        super(itemView);

        mItemTitle = (TextView) itemView.findViewById(R.id.item_title);
        mCity = (TextView) itemView.findViewById(R.id.item_subtitle);
        mRecordings = (TextView) itemView.findViewById(R.id.recordings);
        mSoundboard = (TextView) itemView.findViewById(R.id.soundboard);
    }

    public void bindItem(MyItem item) {

        //I put code here to load item data into the various views in my ViewHolder.
    }
}

    /*
    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ItemAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTypeView.setText(mValues.get(position).id);
        holder.mPriceView.setText(mValues.get(position).content);
        holder.mQuantityView.setText("quantity: 23");

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    //todo: data from DB
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTypeView;
        public final TextView mPriceView;
        public final TextView mQuantityView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTypeView = (TextView) view.findViewById(R.id.type);
            mPriceView = (TextView) view.findViewById(R.id.price);
            mQuantityView = (TextView) view.findViewById(R.id.quantity);

        }

        //todo
        @Override
        public String toString() {
            return super.toString() + " '" + mTypeView.getText() + "'";
        }
    }
}
*/