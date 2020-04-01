package com.example.alternativelayoutfiles

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.alternativelayoutfiles.model.CityDataItem
import java.io.IOException
import java.io.InputStream

class DetailFragment : Fragment() {

    private lateinit var tv_name: TextView
    private lateinit var tv_capital: TextView
    private lateinit var tv_desc: TextView
    private lateinit var tv_population: TextView
    private lateinit var iv_city: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        initFragmentViews(rootView)

        return rootView

    }

    private fun initFragmentViews(rootView: View) {
        this.tv_name = rootView.findViewById(R.id.tv_name)
        this.tv_capital = rootView.findViewById(R.id.tv_capital)
        this.tv_desc = rootView.findViewById(R.id.tv_desc)
        this.tv_population = rootView.findViewById(R.id.tv_population)
        this.iv_city = rootView.findViewById(R.id.imageView)

    }

    fun displayCityData(item: CityDataItem) {
        this.tv_name.setText(item.cityName)
        this.tv_population.setText(item.population.toString())
        this.tv_capital.setText(item.province)
        this.tv_desc.setText(item.description)
        var inputStream: InputStream? = null
        try {
            inputStream = activity?.assets?.open(item.image)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            this.iv_city.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (inputStream == null) {
                try {
                    inputStream!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

}
