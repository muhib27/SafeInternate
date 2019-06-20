package com.champs21.safeinternate.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.champs21.safeinternate.R;
import com.champs21.safeinternate.activity.model.Item;

import java.util.ArrayList;


public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Item> mValues;
    private Context mContext;
    protected ItemListener mListener;
    private static final int HERO = 2;
    private static final int ITEM = 0;

    public EventAdapter(Context context, ArrayList<Item> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        private TextView textView;
//        private ImageView imageView;
//        private RelativeLayout relativeLayout;
//        private Item item;
//
//        public ViewHolder(View v) {
//            super(v);
//            v.setOnClickListener(this);
//            textView = (TextView) v.findViewById(R.id.textView);
//            imageView = (ImageView) v.findViewById(R.id.imageView);
//            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
//        }
//
//        public void setData(Item item) {
//            this.item = item;
//            textView.setText(item.text);
//            imageView.setImageResource(item.drawable);
//            relativeLayout.setBackgroundColor(Color.parseColor(item.color));
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mListener != null) {
//                mListener.onItemClick(item);
//            }
//        }
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false);
//        return new ViewHolder(view);
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.row_item, parent, false);
                viewHolder = new MovieVH(viewItem);
                break;

            case HERO:
                View viewHero = inflater.inflate(R.layout.item_hero, parent, false);
                viewHolder = new HeroVH(viewHero);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Item result = mValues.get(position);
        switch (getItemViewType(position)) {
            case HERO:
                final HeroVH topItem = (HeroVH) viewHolder;
                topItem.title.setText(result.getText());
                break;
            case ITEM:
                final MovieVH itemHolder = (MovieVH) viewHolder;
                itemHolder.title.setText(result.getText());

                break;
        }
    }

//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, int position) {
//        viewHolder.setData(mValues.get(position));
//    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0) {
//            return HERO;
//        } else
            return ITEM;
    }

    public interface ItemListener {
        void onItemClick(Item item);
    }


    protected class MovieVH extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView mMovieDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mPosterImg;
        private ProgressBar mProgress;
        private TextView menuOption;
        private FrameLayout itemLayout;

        public MovieVH(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView);

        }
    }

    protected class HeroVH extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView mMovieDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mPosterImg;
        private CardView cardView;

        public HeroVH(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
        }
    }
}