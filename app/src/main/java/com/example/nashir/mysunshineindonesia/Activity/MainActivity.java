package com.example.nashir.mysunshineindonesia.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nashir.mysunshineindonesia.R;
import com.example.nashir.mysunshineindonesia.Adapter.WeatherAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    /**private ImageView mainWeatherImage;
    private TextView mainWeatherDesc;
    private TextView mainWeatherTemp;
    private RecyclerView mainWeatherList;
    private TextView mainToday;
    private WeatherAdapter weatherAdapter;*/
    @BindView(R.id.main_today) TextView mainToday;
    @BindView(R.id.main_weather_image) ImageView mainWeatherImage;
    @BindView(R.id.main_weather_desc) TextView mainWeatherDesc;
    @BindView(R.id.main_weather_temp) TextView mainWeatherTemp;
    @BindView(R.id.main_weather_list) RecyclerView mainWeatherList;

    WeatherAdapter weatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        /*mainToday = findViewById(R.id.main_today);
        mainWeatherImage = findViewById(R.id.main_weather_image);
        mainWeatherDesc = findViewById(R.id.main_weather_desc);
        mainWeatherTemp = findViewById(R.id.main_weather_temp);
        mainWeatherList = findViewById(R.id.main_weather_list);
*/
        mainWeatherList.setLayoutManager(new LinearLayoutManager(this));
        mainWeatherList.setHasFixedSize(true);

        mainToday.setText("Minggu");
        mainWeatherImage.setImageResource(R.mipmap.ic_launcher_round);
        mainWeatherDesc.setText("Cuaca Berawan");
        mainWeatherTemp.setText("100" + getString(R.string.degree));

        weatherAdapter = new WeatherAdapter();
        mainWeatherList.setAdapter(weatherAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            Toast.makeText(this, "Ini menu Setting", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }


}