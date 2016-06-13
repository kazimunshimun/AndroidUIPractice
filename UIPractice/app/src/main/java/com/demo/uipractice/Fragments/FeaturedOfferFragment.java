package com.demo.uipractice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.uipractice.Adapters.FeaturedOfferAdapter;
import com.demo.uipractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeaturedOfferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeaturedOfferFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    FeaturedOfferAdapter mAdapter;
    SwipeRefreshLayout mSwipeRefreshView;

    int offerPosition = 0;


    public FeaturedOfferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeaturedOfferFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeaturedOfferFragment newInstance(int postion) {
        FeaturedOfferFragment fragment = new FeaturedOfferFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, postion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            offerPosition = getArguments().getInt(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View containerView = inflater.inflate(R.layout.fragment_featured_offer, container, false);
        mSwipeRefreshView = (SwipeRefreshLayout) containerView.findViewById(R.id.refreshLayout);
        mSwipeRefreshView.setColorSchemeResources(R.color.colorPrimary);
        mRecyclerView = (RecyclerView) containerView.findViewById(R.id.offerListRecyclerView);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setSpanCount(1);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new FeaturedOfferAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return containerView;
    }

}
