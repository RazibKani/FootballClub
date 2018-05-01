package com.razibkani.footballclub.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by razibkani on 27/04/18.
 */
data class FootballClub(val image: Int, val name: String, val description: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FootballClub> {
        override fun createFromParcel(parcel: Parcel): FootballClub {
            return FootballClub(parcel)
        }

        override fun newArray(size: Int): Array<FootballClub?> {
            return arrayOfNulls(size)
        }
    }
}