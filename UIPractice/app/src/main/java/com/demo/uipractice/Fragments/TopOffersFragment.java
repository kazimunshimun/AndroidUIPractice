package com.demo.uipractice.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.uipractice.Adapters.TopOfferAdapter;
import com.demo.uipractice.R;

/**
 * Created by Ratan on 7/29/2015.
 */
public class TopOffersFragment extends Fragment {

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    TopOfferAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View containerView = inflater.inflate(R.layout.fragment_category, container, false);
        mRecyclerView = (RecyclerView) containerView.findViewById(R.id.categoryRecyclerView);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setSpanCount(1);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new TopOfferAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return containerView;
    }
}
