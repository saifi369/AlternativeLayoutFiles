package com.example.alternativelayoutfiles

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alternativelayoutfiles.adapters.MyDataAdapter
import com.example.alternativelayoutfiles.model.CityDataItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ICityDataListener {

    var usingTablets: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

//        val viewGroup = findViewById<ViewGroup>(R.id.details_fragment_container)

        usingTablets = resources.getBoolean(R.bool.using_dual_pane)

        Toast.makeText(this, "Wide Screen? $usingTablets", Toast.LENGTH_LONG).show()

    }

    override fun displayCityData(item: CityDataItem) {

        if (usingTablets) {
            val detailFragment =
                supportFragmentManager.findFragmentById(R.id.details_fragment_container) as DetailFragment
            detailFragment.displayCityData(item)

        } else {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(MyDataAdapter.DATA_KEY, item)
            startActivity(intent)
        }

    }

}
