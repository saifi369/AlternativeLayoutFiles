package com.example.alternativelayoutfiles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alternativelayoutfiles.model.CityDataItem;
import com.example.alternativelayoutfiles.sample.SampleDataProvider;

import java.io.IOException;
import java.io.InputStream;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvName, tvCapital, tvDesc, tvPopulation;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        CityDataItem dataItem=getIntent().getParcelableExtra("data_key");

        initViews();

        displayCityData(dataItem);

    }

    private void initViews() {

        this.tvName = findViewById(R.id.tv_name);
        this.tvCapital = findViewById(R.id.tv_capital);
        this.tvDesc = findViewById(R.id.tv_desc);
        this.tvPopulation = findViewById(R.id.tv_population);
        this.imageView = findViewById(R.id.imageView);

    }

    private void displayCityData(CityDataItem item) {

        this.tvName.setText(item.getCityName());
        this.tvPopulation.setText(String.valueOf(item.getPopulation()));
        this.tvCapital.setText(item.getProvince());
        this.tvDesc.setText(item.getDescription());

        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(item.getImage());
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            this.imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream == null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
