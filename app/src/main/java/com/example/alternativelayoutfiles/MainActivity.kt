package com.example.alternativelayoutfiles

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alternativelayoutfiles.model.CityDataItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ICityDataListener {


    private var usingTablets = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val viewGroup = findViewById<ViewGroup>(R.id.details_fragment_container)

        if (viewGroup != null) {
            usingTablets = true
        }

        Toast.makeText(this, "Wide Screen? : $usingTablets", Toast.LENGTH_LONG).show()

    }

    override fun displayCityData(item: CityDataItem) {

        if (usingTablets) {
            val fragment =
                supportFragmentManager.findFragmentById(R.id.details_fragment_container) as DetailFragment
            fragment.displayCityData(item)
        }else{

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("key", item)

            startActivity(intent)

        }

    }

}
