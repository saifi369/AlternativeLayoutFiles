package com.example.alternativelayoutfiles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alternativelayoutfiles.adapters.MyDataAdapter
import com.example.alternativelayoutfiles.model.CityDataItem

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val item = intent.getParcelableExtra<CityDataItem>(MyDataAdapter.DATA_KEY)

        val detailFragment =
            supportFragmentManager.findFragmentById(R.id.details_fragment) as DetailFragment

        detailFragment.displayCityData(item)



    }
}