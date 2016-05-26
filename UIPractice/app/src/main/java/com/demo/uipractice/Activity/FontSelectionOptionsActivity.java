package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.uipractice.Adapters.FontSelectionAdapter;
import com.demo.uipractice.Models.UIMenu;
import com.demo.uipractice.R;
import com.demo.uipractice.Views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class FontSelectionOptionsActivity extends AppCompatActivity {

    private List<UIMenu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FontSelectionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_selection_options);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new FontSelectionAdapter(menuList, FontSelectionOptionsActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMenuData();

    }

    private void prepareMenuData() {

        UIMenu offerDetailMenu1 = new UIMenu("Arciform", "Arciform font on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu1);

        UIMenu offerDetailMenu2 = new UIMenu("Athene", "Athene on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu2);

        UIMenu offerDetailMenu3 = new UIMenu("Corbert Regular", "Corbert Regular on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu3);

        UIMenu offerDetailMenu4 = new UIMenu("Fabrica", "Fabrica on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu4);

        UIMenu offerDetailMenu5 = new UIMenu("Fins Regular", "Fins Regular on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu5);

        UIMenu offerDetailMenu8 = new UIMenu("Gravity book", "Gravity Book on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu8);

        UIMenu offerDetailMenu7 = new UIMenu("Gravity Light", "Gravity Light on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu7);

        UIMenu offerDetailMenu6 = new UIMenu("Gravity Regular", "Gravity Regular on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu6);

        UIMenu offerDetailMenu9 = new UIMenu("Hanken book", "Hanken Book on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu9);

        UIMenu offerDetailMenu10 = new UIMenu("Hanken light", "Hanken light on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu10);

        UIMenu offerDetailMenu12 = new UIMenu("Leto", "Leto on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu12);

        UIMenu offerDetailMenu13 = new UIMenu("Mensch Bold", "Mensch Bold on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu13);

        UIMenu offerDetailMenu14 = new UIMenu("Metrisch Book", "Metrisch Book on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu14);

        UIMenu offerDetailMenu15 = new UIMenu("Peir Regular", "Peir Regular on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu15);

        UIMenu offerDetailMenu16 = new UIMenu("Quark Light", "Quark Light on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu16);

        UIMenu offerDetailMenu17 = new UIMenu("Roboto Light", "Roboto Light on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu17);

        UIMenu offerDetailMenu18 = new UIMenu("Roboto Medium", "Roboto Medium on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu18);

        UIMenu offerDetailMenu19 = new UIMenu("Roboto regular", "Roboto regular on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu19);

        UIMenu offerDetailMenu20 = new UIMenu("Trebuchet MS", "Trebuchet MS on Offer detail", android.R.drawable.ic_menu_compass);
        menuList.add(offerDetailMenu20);

        mAdapter.notifyDataSetChanged();
    }
}
