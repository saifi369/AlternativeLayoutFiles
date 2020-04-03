package com.example.alternativelayoutfiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alternativelayoutfiles.adapters.MyDataAdapter
import com.example.alternativelayoutfiles.sample.SampleDataProvider

class CityDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_city_data, container, false)

        setUpRecyclerView(view)

        return view
    }

    private fun setUpRecyclerView(view: View) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.city_data_recycylerview)

        val adapter = MyDataAdapter(SampleDataProvider.cityDataItemList, context!!)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter=adapter

    }

}
