package com.demo.uipractice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.demo.uipractice.R;
import com.demo.uipractice.Views.ImageUtils;

public class BlurEffectActivity extends AppCompatActivity {

    private static final String BLURRED_IMG_PATH = "blurred_image.png";

    private ImageView mBlurredImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_effect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


// Get the screen width
        final int screenWidth = ImageUtils.getScreenWidth(this);

        // Find the view
      //  mBlurredImage = (ImageView) findViewById(R.id.blurred_image);

    }



}
