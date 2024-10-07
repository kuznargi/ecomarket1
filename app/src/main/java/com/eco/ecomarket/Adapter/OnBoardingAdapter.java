package com.eco.ecomarket.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.eco.ecomarket.R;

public class OnBoardingAdapter extends PagerAdapter {
    Context context;
    int sliderAllBackgrounds[]={
            R.drawable.onboarding_first,
            R.drawable.onboarding_second,
            R.drawable.onboarding_third
    };

    int sliderAllTitle[]={
            R.string.title1,
            R.string.title2,
            R.string.title3
    };


    public OnBoardingAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return sliderAllTitle.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout) object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_screen, container, false); // Replace with your layout

        LinearLayout sliderImage= (LinearLayout) view.findViewById(R.id.background);
        TextView sliderTitle=(TextView) view.findViewById(R.id.slidertitle);

        sliderImage.setBackgroundResource(sliderAllBackgrounds[position]);
        sliderTitle.setText(this.sliderAllTitle[position]);

      container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((LinearLayout)object);
    }
}
