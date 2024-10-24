package com.eco.ecomarket.Controller;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eco.ecomarket.Model.AirPollution.PollutionData;
import com.eco.ecomarket.R;

import com.eco.ecomarket.databinding.FragmentHomeBinding;
import com.eco.ecomarket.utils.RetrofitClient;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    PieChart pieChart;

    TextView tvFirst, tvSecond, tvThird, tvFourth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initWidgets(view);
        fetchPollutionData();
        showPieChart();
        // Setup BarChart
        String[] quarters = { "CO", "NH3", "NO", "NO2", "PM10", "O3", "PM2_5", "SO2"};
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };
        binding.barChart.getXAxis().setValueFormatter(formatter);

        return view;
    }
 void initWidgets(View view){
        pieChart=view.findViewById(R.id.piechart);
     tvFirst=view.findViewById(R.id.tvFirst);
     tvSecond=view.findViewById(R.id.tvSecond);
     tvThird=view.findViewById(R.id.tvThird);
     tvFourth=view.findViewById(R.id.tvFourth);



  }
    private void fetchPollutionData() {
        RetrofitClient.getApi().getPollution(48.019573, 66.923683 , getString(R.string.api_key))
                .enqueue(new Callback<PollutionData>() {
                    @Override
                    public void onResponse(Call<PollutionData> call, Response<PollutionData> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("PollutionResponse", response.body().toString());

                            if (response.body().getList() != null && !response.body().getList().isEmpty()) {
                                double co = response.body().getList().get(0).getComponents().getCo();
                                double nh3 = response.body().getList().get(0).getComponents().getNh3();
                                double no = response.body().getList().get(0).getComponents().getNo();
                                double no2 = response.body().getList().get(0).getComponents().getNo2();
                                double o3 = response.body().getList().get(0).getComponents().getO3();
                                double pm10 = response.body().getList().get(0).getComponents().getPm10();
                                double pm2_5 = response.body().getList().get(0).getComponents().getPm2_5();
                                double so2 = response.body().getList().get(0).getComponents().getSo2();

                                // Log the retrieved values
                                Log.d("ChartData", "CO: " + co + ", NH3: " + nh3 + ", NO: " + no + ", NO2: " + no2 + ", O3: " + o3 + ", PM10: " + pm10 + ", PM2.5: " + pm2_5 + ", SO2: " + so2);

                                // Setup charts with retrieved data
                                setupChart(co, nh3, no, no2, o3, pm10, pm2_5, so2);
                            } else {
                                Log.e("PollutionResponse", "List is empty or null.");
                            }
                        } else {
                            Log.e("PollutionResponse", "Response was not successful: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PollutionData> call, Throwable t) {
                        // Handle failure
                    }
                });
    }

    private void setupChart(double co, double nh3, double no, double no2, double o3, double pm10, double pm2_5, double so2) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, (float) co));
        entries.add(new BarEntry(1, (float) nh3));
        entries.add(new BarEntry(2, (float) no));
        entries.add(new BarEntry(3, (float) no2));
        entries.add(new BarEntry(4, (float) o3));
        entries.add(new BarEntry(5, (float) pm10));
        entries.add(new BarEntry(6, (float) pm2_5));
        entries.add(new BarEntry(7, (float) so2));

        BarDataSet dataSet = new BarDataSet(entries, "Air pollution");

        BarData barData = new BarData(dataSet);
        binding.barChart.setData(barData);
        Description description=new Description();
        description.setText("Kazakhstan");
        binding.barChart.setDescription(description);
        binding.barChart.invalidate(); // Refresh the chart
    }
    private void showPieChart(){

        pieChart.addPieSlice(
                new PieModel(
                        "R",
                        20,
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        30,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "C++",
                      10,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                      40,
                        Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();

    }
}
