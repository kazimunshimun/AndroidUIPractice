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

        FontsOverride.setDefaultFont(this, "DEFAULT", "trebuchet_ms.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "trebuchet_ms.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "trebuchet_ms.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "trebuchet_ms.ttf");
    }
}
