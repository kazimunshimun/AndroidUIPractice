package com.demo.uipractice.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.demo.uipractice.Fragments.AboutFragment;
import com.demo.uipractice.Fragments.CategoryFragment;
import com.demo.uipractice.Fragments.FollowedFragment;
import com.demo.uipractice.Fragments.PostOfferFragment;
import com.demo.uipractice.Fragments.TabFragment;
import com.demo.uipractice.R;
import com.demo.uipractice.Services.Utils;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CategoryFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager;
    FrameLayout frameLayout;
    NavigationView navigationView;
    DrawerLayout drawer;

    Toolbar toolbar;

    private static final int ANIM_DURATION_TOOLBAR = 300;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentManager = getSupportFragmentManager();

        setUpView();

        if (savedInstanceState == null) showHome();
    }

    void setUpView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    void showHome(){
        selectedDrawerItem(navigationView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        startIntroAnimation();
        return true;
    }

    private void startIntroAnimation() {

        int actionbarSize = Utils.dpToPx(56);
        toolbar.setTranslationY(-actionbarSize);
        toolbar.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        selectedDrawerItem(item);
        return true;
    }

    private void selectedDrawerItem(MenuItem item){
        int id = item.getItemId();
        Log.d("onNavItemSelected","s");
        Class fragmentClass;

        if (id == R.id.nav_category) {
            // Handle the camera action
            fragmentClass = TabFragment.class;
            //  fragmentTransaction.commit();
        }//else if (id == R.id.nav_top) {
         //   fragmentClass = TopOffersFragment.class;
       // }
        else if (id == R.id.nav_followed) {
            fragmentClass = FollowedFragment.class;
        } else if (id == R.id.nav_post_offer) {
            fragmentClass = PostOfferFragment.class;
        } else if (id == R.id.nav_share) {
            fragmentClass = AboutFragment.class;
        } else if (id == R.id.nav_send) {
            fragmentClass = AboutFragment.class;
        }else {
            fragmentClass = AboutFragment.class;
        }

        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
