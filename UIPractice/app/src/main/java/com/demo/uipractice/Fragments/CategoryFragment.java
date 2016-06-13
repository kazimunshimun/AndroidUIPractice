package com.demo.uipractice.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.demo.uipractice.Adapters.CategoryAdapter;
import com.demo.uipractice.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    Spinner locationSpinner;
    String[] test=new String[]{"Dhaka","Chittagoag", "Rajshahi", "Sylhet"};

    CategoryAdapter mAdapter;

    SwipeRefreshLayout mSwipeRefreshView;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View containerView = inflater.inflate(R.layout.fragment_category, container, false);
        mSwipeRefreshView = (SwipeRefreshLayout) containerView.findViewById(R.id.refreshLayout);
        mSwipeRefreshView.setColorSchemeResources(R.color.colorPrimary);
        mRecyclerView = (RecyclerView) containerView.findViewById(R.id.categoryRecyclerView);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setSpanCount(2);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new CategoryAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

      //  mRecyclerView.setItemAnimator();

     //   locationSpinner = (Spinner) containerView.findViewById(R.id.locationSpinner);

        ArrayAdapter<String> gameKindArray= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, test);
        gameKindArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     //   locationSpinner.setAdapter(gameKindArray);

     //   mRecyclerView.

        return containerView;
    }

    /**
     * Initialize GridView with some injected data and configure OnItemClickListener.
     */
    private void initializeGridView() {

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
