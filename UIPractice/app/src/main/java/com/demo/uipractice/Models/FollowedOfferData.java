package com.demo.uipractice.Models;


import com.demo.uipractice.R;

import java.util.ArrayList;

/**
 * Created by Anik on 4/19/16.
 */
public class FollowedOfferData {

    public static String[] companyNameArray = {"Yellow", "BFC", "Huawei", "Samsung"};
    public static String[] companyOfferNameArray = {"yellow", "bfc", "huawei", "samsung"};
    public static int[] companyLogoImageResourceArray = {R.drawable.cloth_yellow, R.drawable.res_bfc,
             R.drawable.cell_huawei, R.drawable.elec_samsung};
    public static String[] offerValueArray = {"30%", "50%", "70%", "35%"};
    public static String[] offerEndsArray = {"15 days","12 days", "3 days", "27 days"};

    public FollowedOfferData(){
    }

    public static ArrayList<Offer> offerList(){
        ArrayList<Offer> list = new ArrayList<>();
        for (int i = 0; i< companyNameArray.length; i++){
            Offer offer = new Offer();
            offer.companyName = companyNameArray[i];
            offer.offerName = companyOfferNameArray[i];
            offer.logoImageResource = companyLogoImageResourceArray[i];
            offer.discount = offerValueArray[i];
            offer.endDate = offerEndsArray[i];
            offer.id = i;

            list.add(offer);
        }
        return list;
    }

    public static Offer getItem(int id){
        for (Offer offer:offerList()){
            if (offer.id == id){
                return offer;
            }
        }
        return null;
    }
}
