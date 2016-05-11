package com.demo.uipractice.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.uipractice.R;


/**
 * Created by Ratan on 7/27/2015.
 */
public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
            View x =  inflater.inflate(R.layout.tab_layout,null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("pageSelected", "position:"+position);

                if (position == 0) {
                //    setTitle("Page 1");
                    Log.d("pageSelected", "0");
                    getActivity().setTitle("All Categories");

                } else if (position == 1) {
                //    setTitle("Page 2");
                    Log.d("pageSelected", "1");
                    getActivity().setTitle("Featured Offers");
                }
                else if (position == 2) {
                //    setTitle("Page 3");
                    Log.d("pageSelected", "2");
                    getActivity().setTitle("Top Offers");
                }
                else if (position == 3) {
                    //    setTitle("Page 3");
                    Log.d("pageSelected", "2");
                    getActivity().setTitle("Followed");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                   }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
          switch (position){
              case 0 : return new CategoryFragment();
              case 1 : return new FeaturedOfferFragment();
              case 2 : return new TopOffersFragment();
              case 3 : return new FollowedFragment();
          }
        return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "All Categories";
                case 1 :
                    return "Featured Offers";
                case 2 :
                    return "Top Offers";
                case 3 :
                    return "Followed";
            }
                return null;
        }
    }

}
