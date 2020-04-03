package com.example.alternativelayoutfiles

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alternativelayoutfiles.model.CityDataItem
import com.example.alternativelayoutfiles.sample.SampleDataProvider
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ICityDataListener{

    private val datalist=SampleDataProvider.cityDataItemList
    private var usingFragments=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            Snackbar.make(it,"Hello from the App",Snackbar.LENGTH_LONG).show()
        }

        val fragmentView=findViewById<ViewGroup>(R.id.details_fragment_container)

        if(fragmentView != null)
            usingFragments=true

        Toast.makeText(this,"Using fragment ? : $usingFragments",Toast.LENGTH_LONG)
            .show()
    }

    override fun displayCityData(item: CityDataItem) {

        if(!usingFragments){
            //start new activity
            var intent=Intent(this,DetailsActivity::class.java)
            intent.putExtra("data_key",item)
            startActivity(intent)

        }else{
            //send data to detail fragment
            val detailFragment= supportFragmentManager.findFragmentById(R.id.details_fragment_container) as DetailFragment
            if (detailFragment != null) {
                detailFragment.displayCityData(item)
            }
        }
    }
}
