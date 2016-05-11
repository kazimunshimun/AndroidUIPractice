package com.demo.uipractice.Models;


import com.demo.uipractice.R;

import java.util.ArrayList;

/**
 * Created by Anik on 4/14/16.
 */
public class CategoryData {

    public static String[] categoryNameArray = {"Automotive",
                                                "Beauty", "Books",
                                                "Cell Phones", "Clothing", "Computer",
                                                "Electronics", "Grocery", "Restaurants",
                                                "Software"};
    public static int[] categoryImageResourceArray = {R.drawable.cat_automotive,
                                                    R.drawable.cat_beauty, R.drawable.cat_books,
                                                    R.drawable.cat_cellphones, R.drawable.cat_cloathing, R.drawable.cat_computers,
                                                    R.drawable.cat_appliances, R.drawable.cat_groceries, R.drawable.cat_restaurants,
                                                    R.drawable.cat_software};

    public static ArrayList<Category> categoryList(){
        ArrayList<Category> list = new ArrayList<>();
        for (int i = 0; i< categoryNameArray.length; i++){
            Category category = new Category();
            category.name = categoryNameArray[i];
            category.imageResource = categoryImageResourceArray[i];
            category.id = i;

            list.add(category);
        }
        return list;
    }

    public static Category getItem(int id){
        for (Category category:categoryList()){
            if (category.id == id){
                return category;
            }
        }
        return null;
    }
}
