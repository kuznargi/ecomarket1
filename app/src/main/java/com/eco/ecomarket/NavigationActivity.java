package com.eco.ecomarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import com.eco.ecomarket.Adapter.OnBoardingAdapter;

public class NavigationActivity extends AppCompatActivity {

    ViewPager sliderViewPager;
    LinearLayout dotIndicator;
    OnBoardingAdapter viewPagerAdapter;
    Button backButton, skipButton;
    CardView nextButton;
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation);

        backButton = findViewById(R.id.btnback);
        nextButton = findViewById(R.id.nextCard);
        skipButton = findViewById(R.id.skipButton);

        sliderViewPager = findViewById(R.id.slideViewPager);
        dotIndicator = findViewById(R.id.dots);

        viewPagerAdapter = new OnBoardingAdapter(this);
        sliderViewPager.setAdapter(viewPagerAdapter);

        setDotIndicator(0); // Initialize dots for the first page

        sliderViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                setDotIndicator(position);
//                backButton.setVisibility(position > 0 ? View.VISIBLE : View.INVISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

//        backButton.setOnClickListener(v -> {
//            if (getItem(0) > 0) {
//                sliderViewPager.setCurrentItem(getItem(-1), true);
//            }
//        });

        nextButton.setOnClickListener(v -> {
            if (getItem(0) < viewPagerAdapter.getCount() - 1) {
                sliderViewPager.setCurrentItem(getItem(1), true);
            } else {
                Intent intent = new Intent(NavigationActivity.this, GetStarted.class);
                startActivity(intent);
                finish();
            }
        });

        skipButton.setOnClickListener(v -> {
            Intent intent = new Intent(NavigationActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void setDotIndicator(int position) {
        int numberOfSlides = viewPagerAdapter.getCount(); // Get the number of slides
        dots = new TextView[numberOfSlides]; // Initialize the dots array
        dotIndicator.removeAllViews(); // Clear existing dots

        for (int i = 0; i < numberOfSlides; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;", Html.FROM_HTML_MODE_LEGACY)); // Create dot
            dots[i].setTextSize(35); // Set text size

            // Default color for inactive dots
            dots[i].setTextColor(getResources().getColor(R.color.green, getApplicationContext().getTheme())); // Change to a gray color for inactive

            dotIndicator.addView(dots[i]); // Add dot to LinearLayout
        }

        // Highlight the active dot
        if (position >= 0 && position < numberOfSlides) {
            dots[position].setTextColor(getResources().getColor(R.color.white, getApplicationContext().getTheme())); // Change to white for the active dot
        }
    }

    private int getItem(int i) {
        return sliderViewPager.getCurrentItem() + i;
    }
}
