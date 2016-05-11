package com.demo.uipractice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.demo.uipractice.Adapters.OfferListAdapter;
import com.demo.uipractice.R;


public class OfferListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    OfferListAdapter mAdapter;
    ImageView mCategoryImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent offerListIntent = getIntent();
        int postion = offerListIntent.getIntExtra("postion", 0);

        mCategoryImageView = (ImageView) findViewById(R.id.categoryImageView);
        setCategoryImage(postion);

        mRecyclerView = (RecyclerView) findViewById(R.id.offerListRecyclerView);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setSpanCount(1);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new OfferListAdapter(this, postion);
        mRecyclerView.setAdapter(mAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                imageResource = R.drawable.cat_electronics;
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
