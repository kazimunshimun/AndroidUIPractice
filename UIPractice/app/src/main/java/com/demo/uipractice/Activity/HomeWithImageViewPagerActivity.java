package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.demo.uipractice.Adapters.ImagePagerAdapter;
import com.demo.uipractice.Fragments.TabFragment;
import com.demo.uipractice.R;
import com.demo.uipractice.Views.AutoScrollViewPager;

public class HomeWithImageViewPagerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    AutoScrollViewPager mViewPager;
    ImagePagerAdapter mImagePagerAdapter;
    String[] mCategoryImageURL =new String[]{
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRHWqP-QeaSf8E-ZXrxALextx2kquYiJQX9vaH7Ojhr0ezriItF",
            "http://howafrica.com/wp-content/uploads/2015/12/shoeper-shoe4-challenge.jpg",
            "http://3.imimg.com/data3/ES/WQ/MY-10496986/gold-necklace-250x250.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ68N5axCIh1Dj0utyXnsF_PgOL1NFIGQXYKhtqLtwo0upy3wJV",
            "http://blog.techdesign.com/wp-content/uploads/2016/02/apggroupindia.com_.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_with_image_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Class fragmentClass = TabFragment.class;
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().replace(R.id.content_frame_pager, fragment).commit();

        mImagePagerAdapter = new ImagePagerAdapter(this, mCategoryImageURL);

        mViewPager = (AutoScrollViewPager) findViewById(R.id.imageViewPager);
        mViewPager.setAdapter(mImagePagerAdapter);
        mViewPager.startAutoScroll();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.home_with_image_view_pager, menu);
        return true;
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
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
