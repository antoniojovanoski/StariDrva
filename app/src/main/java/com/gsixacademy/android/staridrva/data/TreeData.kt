package com.gsixacademy.android.staridrva.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties
@IgnoreExtraProperties
class TreeData() : Parcelable {
    var id: Int = 0
    var name: String? = null
    var height: String? = null
    var locality: String? = null
    var age: String? = null
    var images: ArrayList<String>? = null
    var lat_long: LatLongData? = null
    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()
        height = parcel.readString()
        locality = parcel.readString()
        age = parcel.readString()
        lat_long = parcel.readParcelable(LatLongData::class.java.classLoader)
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(height)
        parcel.writeString(locality)
        parcel.writeString(age)
        parcel.writeParcelable(lat_long, flags)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<TreeData> {
        override fun createFromParcel(parcel: Parcel): TreeData {
            return TreeData(parcel)
        }
        override fun newArray(size: Int): Array<TreeData?> {
            return arrayOfNulls(size)
        }
    }
}