package com.demo.uipractice.Models;


import com.demo.uipractice.R;

import java.util.ArrayList;

/**
 * Created by Anik on 4/15/16.
 */
public class OfferData {

    public static String[] companyNameArray = {};
    public static String[] companyOfferNameArray = {};
    public static int[] companyLogoImageResourceArray = {};
    public static String[] offerValueArray = {};
    public static String[] offerEndsArray = {};

    public static String[] resturantName = {"A&W", "BFC", "Cafe selfie", "Comic Cafe", "KFC"};
    public static String[] resturantOfferName = {"aw", "bfc", "cafeselfie", "comiccafe", "kfc"};
    public static int[] resturantLogo = {R.drawable.res_aw, R.drawable.res_bfc, R.drawable.res_cafeselfe, R.drawable.res_comiccafe, R.drawable.res_kfc};
    public static String[] resturantOfferDiscount = {"30%", "12%", "10%", "5%", "8%"};
    public static String[] resturantOffersEnd = {"15 days", "6 days", "6 days", "10 days", "27 days"};

    public static String[] clothName = {"Lubnan", "noir", "O CODE", "Smartex", "Yellow"};
    public static String[] clothOfferName = {"lubnan", "noir", "ocode", "smartex", "yellow"};
    public static int[] clothLogo = {R.drawable.cloth_lubnan, R.drawable.cloth_noir, R.drawable.cloth_ocode, R.drawable.cloth_smatex, R.drawable.cloth_yellow};
    public static String[] clothOfferDiscount = {"20%", "50%", "70%", "35%", "38%"};
    public static String[] clothOffersEnd = {"25 days", "12 days", "3 days", "1 days", "27 days"};

    public static String[] electronicsName = {"Haier", "Samsung", "Singer", "Walton"};
    public static String[] electronicsOfferName = {"haier", "samsung", "singer", "walton"};
    public static int[] electronicsLogo = {R.drawable.elec_haier, R.drawable.elec_samsung, R.drawable.elec_singer, R.drawable.elec_walton};
    public static String[] electronicsOfferDiscount = {"20%", "50%", "70%", "35%"};
    public static String[] electronicsOffersEnd = {"25 days", "12 days", "3 days", "27 days"};

    public static String[] autoName = {"Tata", "Toyota", "TVS"};
    public static String[] autoOfferName = {"tata", "toyota", "tvs"};
    public static int[] autoLogo = {R.drawable.auto_tata, R.drawable.auto_toyota, R.drawable.auto_tvs};
    public static String[] autoDiscount = {"20%", "50%", "70%"};
    public static String[] autoOffersEnd = {"25 days", "12 days", "3 days"};

    public static String[] beautyName = {"Laser treat", "Unilever"};
    public static String[] beautyOfferName = {"lasertreat", "unilever"};
    public static int[] beautyLogo = {R.drawable.beauty_lasertreat, R.drawable.beauty_unilever};
    public static String[] beautyDiscount = {"20%", "50%"};
    public static String[] beautyOffersEnd = {"25 days", "12 days"};

    public static String[] booksName = {"Rokomari"};
    public static String[] booksOfferName = {"rokomari"};
    public static int[] booksLogo = {R.drawable.book_rokomari};
    public static String[] booksDiscount = {"20%"};
    public static String[] booksOffersEnd = {"25 days"};

    public static String[] computerName = {"Dell"};
    public static String[] computerOfferName = {"dell"};
    public static int[] computerLogo = {R.drawable.comp_dell};
    public static String[] computerDiscount = {"20%"};
    public static String[] computerOffersEnd = {"25 days"};

    public static String[] groceryName = {"Chaldal", "Fresh"};
    public static String[] groceryOfferName = {"chaldal", "fresh"};
    public static int[] groceryLogo = {R.drawable.groc_chaldal, R.drawable.groc_fresh};
    public static String[] groceryDiscount = {"20%", "50%"};
    public static String[] groceryOffersEnd = {"25 days", "12 days"};

    public static String[] cellName = {"G&G", "Huawei", "Symphony", "Walton"};
    public static String[] cellOfferName = {"gg", "huawei", "symphony", "walton"};
    public static int[] cellLogo = {R.drawable.cell_gng, R.drawable.cell_huawei, R.drawable.elec_symphony, R.drawable.elec_walton};
    public static String[] cellDiscount = {"20%", "50%", "30%", "35%"};
    public static String[] cellOffersEnd = {"25 days", "12 days", "22 days", "15 days"};

    public static String[] softName = {"ESET", "PANDA"};
    public static String[] softOfferName = {"eset", "panda"};
    public static int[] softLogo = {R.drawable.soft_eset, R.drawable.soft_panda};
    public static String[] softDiscount = {"20%", "50%"};
    public static String[] softOffersEnd = {"25 days", "12 days"};

    public OfferData(int type){

        if (type == 0){
            companyNameArray = new String[3];
            companyOfferNameArray = new String[3];
            offerValueArray = new String[3];
            offerEndsArray = new String[3];
            companyLogoImageResourceArray = new int[3];
            for (int i = 0; i<3; i++){
                companyNameArray[i] = autoName[i];
                companyOfferNameArray[i] = autoOfferName[i];
                companyLogoImageResourceArray[i] = autoLogo[i];
                offerValueArray[i] = autoDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+autoOffersEnd[i];
            }
        }

        if (type == 1){
            companyNameArray = new String[2];
            companyOfferNameArray = new String[2];
            offerValueArray = new String[2];
            offerEndsArray = new String[2];
            companyLogoImageResourceArray = new int[2];
            for (int i = 0; i<2; i++){
                companyNameArray[i] = beautyName[i];
                companyOfferNameArray[i] = beautyOfferName[i];
                companyLogoImageResourceArray[i] = beautyLogo[i];
                offerValueArray[i] = beautyDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+beautyOffersEnd[i];

            }
        }

        if (type == 2){
            companyNameArray = new String[1];
            companyOfferNameArray = new String[1];
            offerValueArray = new String[1];
            offerEndsArray = new String[1];
            companyLogoImageResourceArray = new int[1];
            for (int i = 0; i<1; i++){
                companyNameArray[i] = booksName[i];
                companyOfferNameArray[i] = booksOfferName[i];
                companyLogoImageResourceArray[i] = booksLogo[i];
                offerValueArray[i] = booksDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+booksOffersEnd[i];

            }
        }

        if (type == 3){
            companyNameArray = new String[4];
            companyOfferNameArray = new String[4];
            offerValueArray = new String[4];
            offerEndsArray = new String[4];
            companyLogoImageResourceArray = new int[4];
            for (int i = 0; i<4; i++){
                companyNameArray[i] = cellName[i];
                companyOfferNameArray[i] = cellOfferName[i];
                companyLogoImageResourceArray[i] = cellLogo[i];
                offerValueArray[i] = cellDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+cellOffersEnd[i];

            }
        }

        if (type == 4){
            companyNameArray = new String[5];
            companyOfferNameArray = new String[5];
            offerValueArray = new String[5];
            offerEndsArray = new String[5];
            companyLogoImageResourceArray = new int[5];
            for (int i = 0; i<5; i++){
                companyNameArray[i] = clothName[i];
                companyOfferNameArray[i] = clothOfferName[i];
                companyLogoImageResourceArray[i] = clothLogo[i];
                offerValueArray[i] = clothOfferDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+clothOffersEnd[i];

            }
        }

        if (type == 5){
            companyNameArray = new String[1];
            companyOfferNameArray = new String[1];
            offerValueArray = new String[1];
            offerEndsArray = new String[1];
            companyLogoImageResourceArray = new int[1];
            for (int i = 0; i<1; i++){
                companyNameArray[i] = computerName[i];
                companyOfferNameArray[i] = computerOfferName[i];
                companyLogoImageResourceArray[i] = computerLogo[i];
                offerValueArray[i] = computerDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+computerOffersEnd[i];

            }
        }

        if (type == 6){
            companyNameArray = new String[4];
            companyOfferNameArray = new String[4];
            offerValueArray = new String[4];
            offerEndsArray = new String[4];
            companyLogoImageResourceArray = new int[4];
            for (int i = 0; i<4; i++){
                companyNameArray[i] = electronicsName[i];
                companyOfferNameArray[i] = electronicsOfferName[i];
                companyLogoImageResourceArray[i] = electronicsLogo[i];
                offerValueArray[i] = electronicsOfferDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+electronicsOffersEnd[i];
            }
        }


        if (type == 7){
            companyNameArray = new String[2];
            companyOfferNameArray = new String[2];
            offerValueArray = new String[2];
            offerEndsArray = new String[2];
            companyLogoImageResourceArray = new int[2];
            for (int i = 0; i<2; i++){
                companyNameArray[i] = groceryName[i];
                companyOfferNameArray[i] = groceryOfferName[i];
                companyLogoImageResourceArray[i] = groceryLogo[i];
                offerValueArray[i] = groceryDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+groceryOffersEnd[i];
            }
        }

        if (type == 8){
            companyNameArray = new String[5];
            companyOfferNameArray = new String[5];
            offerValueArray = new String[5];
            offerEndsArray = new String[5];
            companyLogoImageResourceArray = new int[5];
            for (int i = 0; i<5; i++){
                companyNameArray[i] = resturantName[i];
                companyOfferNameArray[i] = resturantOfferName[i];
                companyLogoImageResourceArray[i] = resturantLogo[i];
                offerValueArray[i] = resturantOfferDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+resturantOffersEnd[i];

            }
        }

        if (type == 9){
            companyNameArray = new String[2];
            companyOfferNameArray = new String[2];
            offerValueArray = new String[2];
            offerEndsArray = new String[2];
            companyLogoImageResourceArray = new int[2];
            for (int i = 0; i<2; i++){
                companyNameArray[i] = softName[i];
                companyOfferNameArray[i] = softOfferName[i];
                companyLogoImageResourceArray[i] = softLogo[i];
                offerValueArray[i] = softDiscount[i] +" off";
                offerEndsArray[i] = "Ends in "+softOffersEnd[i];

            }
        }
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
