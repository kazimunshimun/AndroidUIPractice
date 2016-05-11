package com.demo.uipractice.Models;


import com.demo.uipractice.R;

import java.util.ArrayList;

/**
 * Created by Anik on 4/19/16.
 */
public class FeaturedOfferData {

    public static String[] companyNameArray = {"A&W", "noir", "Yellow", "Samsung", "Rokomari", "Toyota", "ESET", "Dell"};
    public static String[] companyOfferNameArray = {"aw", "noir", "yellow", "samsung", "rokomari", "toyota", "eset", "dell"};
    public static int[] companyLogoImageResourceArray = {R.drawable.res_aw, R.drawable.cloth_noir,
            R.drawable.cloth_yellow, R.drawable.elec_samsung, R.drawable.book_rokomari, R.drawable.auto_toyota,
            R.drawable.soft_eset, R.drawable.comp_dell};
    public static String[] offerValueArray = {"30%","50%", "70%", "35%","20%","30%","50%","20%"};
    public static String[] offerEndsArray = {"15 days","12 days", "3 days", "27 days", "25 days", "22 days", "12 days", "25 days"};

    public FeaturedOfferData(){
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
