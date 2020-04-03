package com.example.alternativelayoutfiles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alternativelayoutfiles.model.CityDataItem

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val cityDataItem = intent.getParcelableExtra<CityDataItem>("key")

        val fragment =
            supportFragmentManager.findFragmentById(R.id.details_fragment) as DetailFragment
        fragment.displayCityData(cityDataItem)

    }
}