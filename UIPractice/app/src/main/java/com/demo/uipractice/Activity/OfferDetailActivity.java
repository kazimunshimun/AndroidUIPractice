package com.demo.uipractice.Activity;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.demo.uipractice.Models.Offer;
import com.demo.uipractice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfferDetailActivity extends AppCompatActivity{

    private FragmentManager fragmentManager;
 //   private ContextMenuDialogFragment mMenuDialogFragment;
    TextView bandNameTextView, offerTextTextView;

    ScrollView mDetailScrollView;
    ImageView mOfferImageView;

    ImageButton mLikeButton, mRateButton, mFollowButton;
    TextView mLikeCountTextView, mRateCountTextView, mFollowCountTextView;

    int likeCount = 187, followCount = 33;

    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail);

        bandNameTextView = (TextView) findViewById(R.id.bandNameTextView);
        offerTextTextView = (TextView) findViewById(R.id.offerTextTextView);

        mOfferImageView = (ImageView) findViewById(R.id.imageView);
        mDetailScrollView = (ScrollView) findViewById(R.id.scrollView);

        mLikeButton = (ImageButton) findViewById(R.id.likeButton);
        mRateButton = (ImageButton) findViewById(R.id.ratingButton);
        mFollowButton = (ImageButton) findViewById(R.id.followButton);

        mLikeCountTextView = (TextView) findViewById(R.id.likeCountTextView);
        mRateCountTextView = (TextView) findViewById(R.id.ratingTextView);
        mFollowCountTextView = (TextView) findViewById(R.id.followCountTextView);

        mLikeCountTextView.setText(""+likeCount);
        mFollowCountTextView.setText(""+followCount);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent offerDetailIntent = getIntent();
        Offer offer = (Offer)offerDetailIntent.getSerializableExtra("offerObject");
        String companyName = offerDetailIntent.getStringExtra("name");
        Log.d("companyName", companyName);
        Log.d("discount", offer.discount);
        Log.d("endDate", offer.endDate);

        bandNameTextView.setText(offer.companyName);
        offerTextTextView.setText(offer.discount+" on all products");
        showImage("drawable/offer_"+companyName);
     //   int resId = getResId(companyName, Drawable.class);
     //   Log.d("resID", ""+resId);

     //   setTitle(companyName);
     //   toolbar.setTitle(companyName);

        fragmentManager = getSupportFragmentManager();
        initToolbar();

        animateUserProfileHeader();
    //    initMenuFragment();
      //  addFragment(new MainFragment(), true, R.id.container);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLikeButton.setImageResource(R.drawable.liked);
                incrementCounter(mLikeCountTextView, likeCount);
            }
        });

        mRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRateButton.setImageResource(R.drawable.nav_followed_done);

            }
        });

        mFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFollowButton.setImageResource(R.drawable.ic_heart_red);
                incrementCounter(mFollowCountTextView, followCount);
            }
        });

     //   serverCall();
    }

    void incrementCounter(final TextView view, int count){
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(count, count+1);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(1000);
        animator.start();
    }


    void serverCall(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://nahid002345-001-site1.ftempurl.com/api/offer/getcategorylist";
     //   String url = "http://jsonplaceholder.typicode.com/posts";

// Request a string response from the provided URL.
        /*
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // mTextView.setText("Response is: "+ response.substring(0,500));
                        Log.d("response", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("response","That didn't work!");
            }
        });
*/
        JsonArrayRequest jsObjRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                      //  mTxtDisplay.setText("Response: " + response.toString());
                        Log.d("response", ""+response);
                        for (int i = 0; i< response.length();i++){
                            try {
                                JSONObject categoryObject = response.getJSONObject(i);
//                                Log.d("categoryName",categoryObject.getString("CategoryName"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("response","That didn't work!");
                    }
                });

// Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
/*
    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize(56);
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
        mMenuDialogFragment.setItemLongClickListener(this);
    }
*/
    /*
    private List<MenuObject> getMenuObjects() {

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);


        MenuObject like = new MenuObject("Like offer");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Follow this company");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);

        MenuObject addFav = new MenuObject("Add to favorites");
        addFav.setResource(R.drawable.icn_4);


        menuObjects.add(close);
        menuObjects.add(like);
        menuObjects.add(addFr);
        menuObjects.add(addFav);
        return menuObjects;
    }
*/

    protected void addFragment(Fragment fragment, boolean addToBackStack, int containerId) {
        invalidateOptionsMenu();
        String backStackName = fragment.getClass().getName();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStackName, 0);
        if (!fragmentPopped) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containerId, fragment, backStackName)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            if (addToBackStack)
                transaction.addToBackStack(backStackName);
            transaction.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        //    case R.id.context_menu:
        //        break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onMenuItemClick(View clickedView, int position) {
        Toast.makeText(this, "Clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }
*/
    private void showImage(String uri) {
     //    int imageResource = R.drawable.tata;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());

        if (imageResource != 0){

            Drawable image = getResources().getDrawable(imageResource);
            mOfferImageView.setImageDrawable(image);
        }

    }

    private void animateUserProfileHeader() {
        mOfferImageView.setTranslationY(-mOfferImageView.getHeight());
        mDetailScrollView.setAlpha(0);

        mOfferImageView.animate().translationY(0).setDuration(300).setInterpolator(INTERPOLATOR);
        mDetailScrollView.animate().alpha(1).setDuration(200).setStartDelay(400).setInterpolator(INTERPOLATOR).start();
    }

}
