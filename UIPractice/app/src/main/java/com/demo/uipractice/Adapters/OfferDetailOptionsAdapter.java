package com.demo.uipractice.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.uipractice.Activity.CircularProgressBarActivity;
import com.demo.uipractice.Activity.OfferDetail1Activity;
import com.demo.uipractice.Activity.OfferDetailOption2Activity;
import com.demo.uipractice.Models.UIMenu;
import com.demo.uipractice.R;

import java.util.List;

/**
 * Created by Anik TigerIT on 5/24/16.
 */
public class OfferDetailOptionsAdapter extends RecyclerView.Adapter<OfferDetailOptionsAdapter.MenuViewHolder> {

    private List<UIMenu> uiMenuList;
    private Context mContext;

    public static class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title, detail;
        public ImageView iconImage;
        public IViewHolderClicks mListener;

        public MenuViewHolder(View view, IViewHolderClicks listener) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            detail = (TextView) view.findViewById(R.id.detail);
            iconImage = (ImageView) view.findViewById(R.id.imageView);
            mListener = listener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onRecycleViewClick(v, getPosition());
        }

        public interface IViewHolderClicks {
            void onRecycleViewClick(View caller, int position);
        }
    }


    public OfferDetailOptionsAdapter(List<UIMenu> menuList, Context context) {
        this.uiMenuList = menuList;
        mContext = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_uimenu, parent, false);
        return new MenuViewHolder(itemView, new MenuViewHolder.IViewHolderClicks() {

            @Override
            public void onRecycleViewClick(View caller, int position) {
                Log.d("clicked", "recycle view. position:"+position);
                switch (position){
                    case 0:
                        Intent offerDetail1Intent = new Intent(mContext, OfferDetail1Activity.class);
                        mContext.startActivity(offerDetail1Intent);
                        break;
                    case 1:
                        Intent option2Intent = new Intent(mContext, OfferDetailOption2Activity.class);
                        mContext.startActivity(option2Intent);
                        break;
                    case 2:
                        Intent circularProgressBarIntent = new Intent(mContext, CircularProgressBarActivity.class);
                        mContext.startActivity(circularProgressBarIntent);
                        break;
                    case 3:

                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        UIMenu uiMenu = uiMenuList.get(position);
        holder.title.setText(uiMenu.getTitle());
        holder.detail.setText(uiMenu.getDetail());
        holder.iconImage.setImageResource(uiMenu.getMenuImageResource());
    }

    @Override
    public int getItemCount() {
        return uiMenuList.size();
    }
}
