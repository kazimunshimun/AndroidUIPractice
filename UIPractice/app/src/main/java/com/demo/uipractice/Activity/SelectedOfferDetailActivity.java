package com.demo.uipractice.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.demo.uipractice.R;

public class SelectedOfferDetailActivity extends AppCompatActivity {

    TextView likeCountTextView, likeTextView, ratingCountTextView, ratingTextView, followCountTextView, followTextView, offerTextTextView,
            bandTextView, bandNameTextView, categoryTextView, categoryNameTextView, expireTextView, expireDateTextView,
            contactTextView, contactValueTextView, websiteTextView, websiteNameTextView, availableTextView, branchesTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_offer_detail);

        Intent selectedFortIntent = getIntent();
        int selectedFontPosition = selectedFortIntent.getIntExtra("selectedFont", 0);
        Log.d("selectedFont", ""+selectedFontPosition);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getFindViewByIdForTextViews();

        Typeface selectedTypeFace = getSelectedTypeface(selectedFontPosition);
        setTextViewsTypeFace(selectedTypeFace);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    void getFindViewByIdForTextViews(){
        likeTextView = (TextView) findViewById(R.id.likeTextView);
        likeCountTextView = (TextView) findViewById(R.id.likeCountTextView);
        ratingTextView = (TextView) findViewById(R.id.ratingTextView);
        ratingCountTextView = (TextView) findViewById(R.id.ratingValueTextView);
        followTextView = (TextView) findViewById(R.id.followTextView);
        followCountTextView = (TextView) findViewById(R.id.followCountTextView);

        offerTextTextView = (TextView) findViewById(R.id.offerTextTextView);
        bandTextView = (TextView) findViewById(R.id.bandTextView);
        bandNameTextView = (TextView) findViewById(R.id.bandNameTextView);
        categoryTextView = (TextView) findViewById(R.id.categoryTextView);
        categoryNameTextView = (TextView) findViewById(R.id.categoryNameTextView);
        expireTextView = (TextView) findViewById(R.id.expireTextView);
        expireDateTextView = (TextView) findViewById(R.id.expireDateTextView);

        contactTextView = (TextView) findViewById(R.id.contactTextView);
        contactValueTextView = (TextView) findViewById(R.id.contactValueTextView);
        websiteTextView = (TextView) findViewById(R.id.websiteTextView);
        websiteNameTextView = (TextView) findViewById(R.id.websiteNameTextView);
        availableTextView = (TextView) findViewById(R.id.availableTextView);
        branchesTextView = (TextView) findViewById(R.id.brancesTextView);
    }

    void setTextViewsTypeFace(Typeface selectedTypeFace){
        likeTextView.setTypeface(selectedTypeFace);
        likeCountTextView.setTypeface(selectedTypeFace);
        ratingTextView.setTypeface(selectedTypeFace);
        ratingCountTextView.setTypeface(selectedTypeFace);
        followTextView.setTypeface(selectedTypeFace);
        followCountTextView.setTypeface(selectedTypeFace);

        offerTextTextView.setTypeface(selectedTypeFace);
        bandTextView.setTypeface(selectedTypeFace);
        bandNameTextView.setTypeface(selectedTypeFace);
        categoryTextView.setTypeface(selectedTypeFace);
        categoryNameTextView.setTypeface(selectedTypeFace);
        expireTextView.setTypeface(selectedTypeFace);
        expireDateTextView.setTypeface(selectedTypeFace);

        contactTextView.setTypeface(selectedTypeFace);
        contactValueTextView.setTypeface(selectedTypeFace);
        websiteTextView.setTypeface(selectedTypeFace);
        websiteNameTextView.setTypeface(selectedTypeFace);
        availableTextView.setTypeface(selectedTypeFace);
        branchesTextView.setTypeface(selectedTypeFace);
    }

    Typeface getSelectedTypeface(int position){
        Typeface selectedTypeface;
        String fontAssetName;
        switch (position){
            case 0:
                fontAssetName = "arciform.otf";
                break;
            case 1:
                fontAssetName = "athene.otf";
                break;
            case 2:
                fontAssetName = "corbert_regular.otf";
                break;
            case 3:
                fontAssetName = "fabrica.otf";
                break;
            case 4:
                fontAssetName = "fins_regular.otf";
                break;
            case 5:
                fontAssetName = "gravity_book.otf";
                break;
            case 6:
                fontAssetName = "gravity_light.otf";
                break;
            case 7:
                fontAssetName = "gravity_regular.otf";
                break;
            case 8:
                fontAssetName = "hanken_book.ttf";
                break;
            case 9:
                fontAssetName = "hanken_light.ttf";
                break;
            case 10:
                fontAssetName = "leto_defect.ttf";
                break;
            case 11:
                fontAssetName = "mensch_bold.ttf";
                break;
            case 12:
                fontAssetName = "metrisch_book.otf";
                break;
            case 13:
                fontAssetName = "pier_regular.otf";
                break;
            case 14:
                fontAssetName = "quark_light.otf";
                break;
            case 15:
                fontAssetName = "roboto_light.ttf";
                break;
            case 16:
                fontAssetName = "roboto_medium.ttf";
                break;
            case 17:
                fontAssetName = "roboto_regular.ttf";
                break;

            default:
                fontAssetName = "roboto_regular.ttf";
                break;
        }
        selectedTypeface = Typeface.createFromAsset(this.getAssets(), fontAssetName);
        Log.d("selectedTypeFace", fontAssetName);
        return selectedTypeface;
    }

}
