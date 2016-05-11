package com.demo.uipractice.Models;


import com.demo.uipractice.R;

import java.util.ArrayList;

/**
 * Created by Anik on 4/19/16.
 */
public class TopOfferData {
    public static String[] companyNameArray = {"BFC", "Smartex", "Yellow", "Singer", "Rokomari", "Huawei", "ESET"};
    public static String[] companyOfferNameArray = {"bfc","smartex", "yellow", "singer", "rokomari", "huawei", "ESET"};
    public static int[] companyLogoImageResourceArray = {R.drawable.res_bfc, R.drawable.cloth_smatex,
            R.drawable.cloth_yellow, R.drawable.elec_singer, R.drawable.book_rokomari, R.drawable.cell_huawei, R.drawable.soft_eset};
    public static String[] offerValueArray = {"30%","50%", "70%", "35%","20%","30%","50%"};
    public static String[] offerEndsArray = {"15 days","12 days", "3 days", "27 days", "25 days", "22 days","12 days"};

    public TopOfferData(){
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
