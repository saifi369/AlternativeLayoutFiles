package com.example.alternativelayoutfiles.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class CityDataItem(
    var cityId: String?,
    var cityName: String,
    var rank: Int,
    var province: String,
    var population: Long,
    var description: String,
    var image: String
) : Parcelable {
    init {
        if (cityId == null) {
            cityId = UUID.randomUUID().toString()
        }
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString().toString(),
        source.readInt(),
        source.readString().toString(),
        source.readLong(),
        source.readString().toString(),
        source.readString().toString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(cityId)
        writeString(cityName)
        writeInt(rank)
        writeString(province)
        writeLong(population)
        writeString(description)
        writeString(image)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CityDataItem> = object : Parcelable.Creator<CityDataItem> {
            override fun createFromParcel(source: Parcel): CityDataItem = CityDataItem(source)
            override fun newArray(size: Int): Array<CityDataItem?> = arrayOfNulls(size)
        }
    }
}