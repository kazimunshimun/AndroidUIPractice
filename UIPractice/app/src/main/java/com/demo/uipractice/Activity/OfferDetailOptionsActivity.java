package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.uipractice.Adapters.OfferDetailOptionsAdapter;
import com.demo.uipractice.Models.UIMenu;
import com.demo.uipractice.R;
import com.demo.uipractice.Views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class OfferDetailOptionsActivity extends AppCompatActivity {

    private List<UIMenu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OfferDetailOptionsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail_options);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new OfferDetailOptionsAdapter(menuList, OfferDetailOptionsActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMenuData();
    }

    private void prepareMenuData() {

        UIMenu offerDetailMenu1 = new UIMenu("Offer Detail", "Offer detail menu 1", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu1);

        UIMenu offerDetailMenu2 = new UIMenu("Offer Detail", "Offer detail menu 2", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu2);

        UIMenu offerDetailMenu3 = new UIMenu("Offer Detail", "Offer detail menu 3", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu3);

        UIMenu offerDetailMenu4 = new UIMenu("Offer Detail", "Offer detail menu 4", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu4);

        UIMenu offerDetailMenu5 = new UIMenu("Offer Detail", "Offer detail menu 5", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu5);

        UIMenu offerDetailMenu6 = new UIMenu("Offer Detail", "Offer detail menu 6", android.R.drawable.ic_menu_agenda);
        menuList.add(offerDetailMenu6);

        mAdapter.notifyDataSetChanged();
    }
}
