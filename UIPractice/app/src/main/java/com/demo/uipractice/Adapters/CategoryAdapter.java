package com.demo.uipractice.Adapters;

import android.app.Activity;
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

import com.demo.uipractice.Activity.OfferListActivity;
import com.demo.uipractice.Models.Category;
import com.demo.uipractice.Models.CategoryData;
import com.demo.uipractice.R;


/**
 * Created by Anik on 4/14/16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context mContext;
    Activity mActivity;

    public CategoryAdapter(Context context, Activity activity){
        this.mContext = context;
        this.mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.CategoryItemClick() {
            @Override
            public void onCard(View v, int position) {
                Log.d("onCard", "click"+position);
                Intent offerListIntent = new Intent(mContext, OfferListActivity.class);
                offerListIntent.putExtra("postion", position);

                int[] startingLocation = new int[2];
                v.getLocationOnScreen(startingLocation);
                offerListIntent.putExtra("ARG_DRAWING_START_LOCATION", startingLocation[1]);

              //  ImageView categoryImageView = (ImageView) v.findViewById(R.id.categoryImageView);
              //  Pair<View, String> imagePair = Pair.create((View) categoryImageView, "Hello");

              //  ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, imagePair);
              //  ActivityCompat.startActivity((Activity) mContext, offerListIntent, options.toBundle());
              //  mContext.startActivity(offerListIntent);

                View heroView = view.findViewById(R.id.categoryImageView);
                OfferListActivity.launch(mActivity, heroView, position);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category = new CategoryData().categoryList().get(position);
        holder.categoryTextView.setText(category.name);
        holder.categoryImageView.setImageResource(category.imageResource);
    }

    @Override
    public int getItemCount() {
        return new CategoryData().categoryList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView categoryImageView;
        TextView categoryTextView;
        LinearLayout categoryLayout;

        public CategoryItemClick mListener;

        public ViewHolder(View itemView, CategoryItemClick listener) {
            super(itemView);
            mListener = listener;
            categoryImageView = (ImageView) itemView.findViewById(R.id.categoryImageView);
            categoryTextView = (TextView) itemView.findViewById(R.id.categoryTextView);
            categoryLayout = (LinearLayout) itemView.findViewById(R.id.categoryLinearLayout);
            categoryLayout.setOnClickListener(this);
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
