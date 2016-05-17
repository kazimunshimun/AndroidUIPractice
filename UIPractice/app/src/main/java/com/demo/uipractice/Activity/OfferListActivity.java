package com.demo.uipractice.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.demo.uipractice.Adapters.OfferListAdapter;
import com.demo.uipractice.R;
import com.demo.uipractice.Services.Utils;


public class OfferListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    OfferListAdapter mAdapter;
    ImageView mCategoryImageView;

    Toolbar toolbar;

    RelativeLayout contentRoot;

    private int drawingStartLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contentRoot = (RelativeLayout) findViewById(R.id.contentRoot);


        Intent offerListIntent = getIntent();
        int position = offerListIntent.getIntExtra("postion", 0);
        drawingStartLocation = offerListIntent.getIntExtra("ARG_DRAWING_START_LOCATION", 0);

        mCategoryImageView = (ImageView) findViewById(R.id.categoryImageView);
        setCategoryImage(position);

        mRecyclerView = (RecyclerView) findViewById(R.id.offerListRecyclerView);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setSpanCount(1);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new OfferListAdapter(this, position);
        mRecyclerView.setAdapter(mAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startIntroAnimation();
    }

    private void startIntroAnimation() {
     //   ViewCompat.setElevation(toolbar, 0);
        contentRoot.setScaleY(0.1f);
        contentRoot.setPivotY(drawingStartLocation);
     //   llAddComment.setTranslationY(200);

        contentRoot.animate()
                .scaleY(1)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ViewCompat.setElevation(toolbar, Utils.dpToPx(8));
                        animateContent();
                    }
                })
                .start();
    }

    private void animateContent() {
    //    commentsAdapter.updateItems();
   //     llAddComment.animate().translationY(0)
    //            .setInterpolator(new DecelerateInterpolator())
    //            .setDuration(200)
    //            .start();
    }

    void setCategoryImage(int position){
        int imageResource;
        switch (position){
            case 0:
                imageResource = R.drawable.cat_automotive;
                break;
            case 1:
                imageResource = R.drawable.cat_beauty;
                break;
            case 2:
                imageResource = R.drawable.cat_books;
                break;
            case 3:
                imageResource = R.drawable.cat_cellphones;
                break;
            case 4:
                imageResource = R.drawable.cat_cloathing;
                break;
            case 5:
                imageResource = R.drawable.cat_computers;
                break;
            case 6:
                imageResource = R.drawable.cat_appliances;
                break;
            case 7:
                imageResource = R.drawable.cat_groceries;
                break;
            case 8:
                imageResource = R.drawable.cat_restaurants;
                break;
            case 9:
                imageResource = R.drawable.cat_software;
                break;
            default:
                imageResource = R.drawable.cat_software;
        }
        mCategoryImageView.setImageResource(imageResource);
    }

}
