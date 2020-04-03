package com.example.alternativelayoutfiles.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alternativelayoutfiles.ICityDataListener
import com.example.alternativelayoutfiles.R
import com.example.alternativelayoutfiles.adapters.MyDataAdapter.MyViewHolder
import com.example.alternativelayoutfiles.model.CityDataItem
import java.io.IOException
import java.io.InputStream


class MyDataAdapter(
    private val mDataList: List<CityDataItem>,
    private val mContext: Context
) : RecyclerView.Adapter<MyViewHolder>() {

    val listener: ICityDataListener = mContext as ICityDataListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cityDataItem = mDataList[position]

        holder.textView.text = cityDataItem.cityName

        var inputStream: InputStream? = null
        try {
            inputStream = mContext.assets.open(cityDataItem.image)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            holder.imageView.setImageBitmap(bitmap)
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

        holder.itemView.setOnClickListener {
            listener.displayCityData(cityDataItem)
        }
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.textView)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)

    }

    companion object {
        const val EXTRA_KEY = "data_key"
    }
}