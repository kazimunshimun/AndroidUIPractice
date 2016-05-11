package com.demo.uipractice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.uipractice.Adapters.FollowedOfferAdapter;
import com.demo.uipractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FollowedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FollowedFragment extends Fragment {

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    FollowedOfferAdapter mAdapter;

    public FollowedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FollwedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FollowedFragment newInstance() {
        FollowedFragment fragment = new FollowedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View containerView = inflater.inflate(R.layout.fragment_featured_offer, container, false);
        mRecyclerView = (RecyclerView) containerView.findViewById(R.id.offerListRecyclerView);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setSpanCount(1);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new FollowedOfferAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return containerView;
    }

}
