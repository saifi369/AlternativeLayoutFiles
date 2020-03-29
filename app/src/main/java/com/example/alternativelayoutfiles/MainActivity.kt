package com.example.alternativelayoutfiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alternativelayoutfiles.adapters.MyDataAdapter
import com.example.alternativelayoutfiles.sample.SampleDataProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val datalist=SampleDataProvider.cityDataItemList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val adapter=MyDataAdapter(datalist,this)
        recyclerview_main.layoutManager=LinearLayoutManager(this)
        recyclerview_main.adapter=adapter
    }
}
