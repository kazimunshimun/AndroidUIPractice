package com.demo.uipractice.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.uipractice.Activity.OfferDetailActivity;
import com.demo.uipractice.Models.Offer;
import com.demo.uipractice.Models.OfferData;
import com.demo.uipractice.R;


/**
 * Created by Anik on 4/15/16.
 */
public class OfferListAdapter extends RecyclerView.Adapter<OfferListAdapter.ViewHolder>{

    Context mContext;
    int mType;

    public OfferListAdapter(Context context, int type){
        this.mContext = context;
        this.mType = type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_offer_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.CategoryItemClick() {
            @Override
            public void onCard(View v, int position) {
                Log.d("onCard", "click"+position);
                Offer offer = new OfferData(mType).offerList().get(position);
                Intent offerDetailIntent = new Intent(mContext, OfferDetailActivity.class);
                offerDetailIntent.putExtra("name", offer.offerName);
                offerDetailIntent.putExtra("offerObject", offer);
                mContext.startActivity(offerDetailIntent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Offer offer = new OfferData(mType).offerList().get(position);
        holder.companyNameTextView.setText(offer.companyName);
        holder.offerDiscountTextView.setText(offer.discount);
        holder.offerEndDateTextView.setText(offer.endDate);
        holder.companyLogoImageView.setImageResource(offer.logoImageResource);

        if (position == 2 || position == 5){
            holder.featuredTextView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return new OfferData(mType).offerList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView companyLogoImageView;
        TextView companyNameTextView;
        TextView offerDiscountTextView;
        TextView offerEndDateTextView;
        LinearLayout offerCompanyLayout;
        TextView featuredTextView;

        public CategoryItemClick mListener;

        public ViewHolder(View itemView, CategoryItemClick listener) {
            super(itemView);
            mListener = listener;
            companyLogoImageView = (ImageView) itemView.findViewById(R.id.companyLogoImageView);
            companyNameTextView = (TextView) itemView.findViewById(R.id.companyNameTextView);
            offerDiscountTextView = (TextView) itemView.findViewById(R.id.percentageOffTextView);
            offerEndDateTextView = (TextView) itemView.findViewById(R.id.endDateTextView);
            offerCompanyLayout = (LinearLayout) itemView.findViewById(R.id.offerCompanyLayout);
            featuredTextView = (TextView) itemView.findViewById(R.id.featuredTextView);
            offerCompanyLayout.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            mListener.onCard( itemView, getPosition());
        }

        public static interface CategoryItemClick{
            public void onCard(View view, int position);
        }
    }
}
