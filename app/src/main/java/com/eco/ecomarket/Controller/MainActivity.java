package com.eco.ecomarket.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.eco.ecomarket.PlatinumFragment;
import com.eco.ecomarket.R;
import com.eco.ecomarket.databinding.ActivityMainBinding;
import com.eco.ecomarket.fragments.AccountFragment;
import com.eco.ecomarket.fragments.AchievemntFragment;
import com.eco.ecomarket.fragments.AddEventFragment;
import com.eco.ecomarket.fragments.CalendarFragment;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment((new HomeFragment()));
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    //replaceFragment(new HomeFragment());
                    //replaceFragment(new );
                    //Intent intent=new Intent(getApplicationContext(), Map.class);
                    //startActivity(intent);
                    break;
                case R.id.account:
                    replaceFragment(new AccountFragment());
                    break;
                case R.id.award:
                    replaceFragment(new PlatinumFragment());
                    break;
                case R.id.calendar:
                    replaceFragment(new CalendarFragment());
                    break;

                default:
                    return false;
            }
            return true;
        });

    }
    private  void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}