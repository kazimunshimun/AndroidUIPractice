package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.demo.uipractice.Adapters.UIMenuAdapter;
import com.demo.uipractice.Models.UIMenu;
import com.demo.uipractice.R;
import com.demo.uipractice.Views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<UIMenu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UIMenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UIMenuAdapter(menuList, MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMenuData();
    }

    private void prepareMenuData() {
        UIMenu defaultNavigationDrawerMenu = new UIMenu("Navigation Drawer", "Default navigation drawer", android.R.drawable.ic_menu_manage);
        menuList.add(defaultNavigationDrawerMenu);

        UIMenu movie1 = new UIMenu("SearchBar", "Default search bar", android.R.drawable.ic_menu_mylocation);
        menuList.add(movie1);

        UIMenu discountBDMenu = new UIMenu("Discount", "Discount BD Demo", android.R.drawable.ic_menu_mylocation);
        menuList.add(discountBDMenu);

        UIMenu circularProgressBarMenu = new UIMenu("Progress Bar", "Circular Progress bar on top of android CardView", android.R.drawable.ic_menu_manage);
        menuList.add(circularProgressBarMenu);

        UIMenu offerDetailMenu1 = new UIMenu("Offer Detail", "Offer detail options", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu1);

        UIMenu fontSelectionMenu = new UIMenu("Font Selection", "Font selection options", android.R.drawable.ic_menu_info_details);
        menuList.add(fontSelectionMenu);

        UIMenu glassViewMenu = new UIMenu("Glass View", "Glass view test", android.R.drawable.ic_menu_info_details);
        menuList.add(glassViewMenu);

        UIMenu blurViewMenu = new UIMenu("Blur View", "Blur view test", android.R.drawable.ic_menu_info_details);
        menuList.add(blurViewMenu);

        mAdapter.notifyDataSetChanged();
    }
}
