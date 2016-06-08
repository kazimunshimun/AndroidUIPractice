package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.uipractice.Adapters.GlassEffectAdapter;
import com.demo.uipractice.Models.UIMenu;
import com.demo.uipractice.R;
import com.demo.uipractice.Views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class GlassEffectSelectionActivity extends AppCompatActivity {

    private List<UIMenu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GlassEffectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass_effect_selection);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new GlassEffectAdapter(menuList, GlassEffectSelectionActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMenuData();
    }

    private void prepareMenuData() {

        UIMenu glassViewMenu = new UIMenu("Glass View", "Glass view test", android.R.drawable.ic_menu_info_details);
        menuList.add(glassViewMenu);

        UIMenu blurViewMenu = new UIMenu("Blur View", "Blur view test", android.R.drawable.ic_menu_info_details);
        menuList.add(blurViewMenu);

        UIMenu blurEffectMenu = new UIMenu("Blur Effect", "Blur effect test", android.R.drawable.ic_menu_info_details);
        menuList.add(blurEffectMenu);

        mAdapter.notifyDataSetChanged();
    }
}
