package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.demo.uipractice.R;

public class OfferDetail1Activity extends AppCompatActivity {

    CollapsingToolbarLayout mCollapsingLayout;
    ImageView mOfferImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCollapsingLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        mOfferImageView = (ImageView) findViewById(R.id.offerImageView);
        mOfferImageView.setImageResource(R.drawable.offer_bfc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //   mCollapsingLayout.setContentScrimResource(R.drawable.offer_bfc);
    }
}
