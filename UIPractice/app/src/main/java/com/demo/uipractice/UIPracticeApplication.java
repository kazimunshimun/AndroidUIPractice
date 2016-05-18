package com.demo.uipractice;

import android.app.Application;

import com.demo.uipractice.Utils.FontsOverride;

/**
 * Created by Anik TigerIT on 5/18/16.
 */
public class UIPracticeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "DEFAULT", "roboto_regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "roboto_regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "roboto_regular.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "roboto_regular.ttf");
    }
}
