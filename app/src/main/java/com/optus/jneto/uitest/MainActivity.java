package com.optus.jneto.uitest;

/**
 * Created by jneto on 10/8/17.
 */

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.optus.jneto.uitest.adapters.CustomFragmentAdapter;
import com.optus.jneto.uitest.utils.CirclePageIndicator;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentTappedListener {

    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String IMAGE_TEXT = "imageText";

    private int color = R.color.white;
    private String displayImageText = "";
    private LinearLayout buttonsLayout;
    private TextView textView;

    @Override
    public void onFragmentTapped(int position) {
        Toast.makeText(getApplicationContext(), "Fragment " + position + " tapped", Toast
                .LENGTH_LONG).show();
    }

    public void onImageClick(View view) {
        displayImageText = getString(R.string.display_image_text, view.getTag());
        textView.setText(displayImageText);
    }

    public void onButtonClick(View view) {


        switch (view.getTag().toString()) {
            case "red" :
                color = R.color.red;
                break;
            case "green" :
                color = R.color.green;
                break;
            case "blue" :
                color = R.color.blue;
                break;
            default:
                color = R.color.white;
                break;
        }

        buttonsLayout.setBackgroundColor(ContextCompat.getColor(this, color));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonsLayout= (LinearLayout) findViewById(R.id.buttonsLayout);
        textView = (TextView) findViewById(R.id.textView);

        CustomFragmentAdapter customFragmentAdapter = new CustomFragmentAdapter(getSupportFragmentManager());
        ViewPager mPager = (ViewPager) findViewById(R.id.container);
        mPager.setAdapter(customFragmentAdapter);

        //Bind the title indicator to the adapter
        CirclePageIndicator circleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(mPager);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BACKGROUND_COLOR, color);
        outState.putString(IMAGE_TEXT, displayImageText);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        color = savedInstanceState.getInt(BACKGROUND_COLOR);
        displayImageText = savedInstanceState.getString(IMAGE_TEXT);
        buttonsLayout.setBackgroundColor(ContextCompat.getColor(this, color));
        if (!displayImageText.isEmpty()) {
            textView.setText(displayImageText);
        }
    }
}
