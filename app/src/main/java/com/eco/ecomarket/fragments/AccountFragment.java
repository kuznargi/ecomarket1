package com.eco.ecomarket.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eco.ecomarket.Adapter.ProfileWidgetAdapter;
import com.eco.ecomarket.Controller.HomeFragment;
import com.eco.ecomarket.Interface.RecyclerViewInterface;
import com.eco.ecomarket.Model.ProfileWidgetModel;
import com.eco.ecomarket.R;

import java.util.ArrayList;

public class AccountFragment extends Fragment implements RecyclerViewInterface {

    ArrayList<ProfileWidgetModel> profileWidgetModels=new ArrayList<>();
    int images[]={
            R.drawable.ic_edit_profile,
            R.drawable.ic_heard,
            R.drawable.award,
            R.drawable.ic_ecology,
            R.drawable.ic_ecology
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        setUpProfileWidgetModels();

        // Initialize RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.profile_widgets);

        ProfileWidgetAdapter adapter=new ProfileWidgetAdapter(getContext(),profileWidgetModels,this);
        recyclerView.setAdapter(adapter);

        return view;
    }
    public void setUpProfileWidgetModels(){
        String[] titles=getResources().getStringArray(R.array.profile_widget_items);
        for(int i=0;i< titles.length;i++){
            profileWidgetModels.add(new ProfileWidgetModel(titles[i],images[i]));

        }
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = null;

        switch (position) {
            case 0:
                intent = new Intent(getContext(), HomeFragment.class); // Example activity
                break;
            case 1:
                intent = new Intent(getContext(), HomeFragment.class);  // Another example activity
                break;
            // Add more cases for other positions
        }

        if (intent != null) {
            getContext().startActivity(intent);  // Start the new activity
        }
    }
}