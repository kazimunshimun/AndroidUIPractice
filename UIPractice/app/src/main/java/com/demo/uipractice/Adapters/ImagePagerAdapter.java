package com.demo.uipractice.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.uipractice.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Anik TigerIT on 6/12/16.
 */
public class ImagePagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    String[] mImageURL;

    public ImagePagerAdapter(Context context, String[] imageURL) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mImageURL = imageURL;
    }

    @Override
    public int getCount() {
        return mImageURL.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_image_pager, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.item_imageView);
      //  imageView.setImageResource(mResources[position]);
        Log.d("debuglogkey", mImageURL[position]);
        Picasso.with(mContext)
                .load(mImageURL[position])
                .placeholder(R.drawable.ic_category)
                .fit()
                // .resize(60, 60)
                //  .centerCrop()
                //  .transform(new CircleTransformation())
                .into(imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      //  container.removeView((LinearLayout) object);
    }
}
