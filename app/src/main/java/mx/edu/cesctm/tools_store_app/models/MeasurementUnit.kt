package mx.edu.cesctm.tools_store_app.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
data class MeasurementUnit(
        @SerializedName("measurement_unit_id") val mId: Int?,
        @SerializedName("name") val mName: String?,
        @SerializedName("description") val mDescription: String?,
        @SerializedName("abbreviation") val mAbbreviation: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            dest.writeValue(mId)
            dest.writeString(mName)
            dest.writeString(mDescription)
            dest.writeString(mAbbreviation)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<MeasurementUnit> {
        override fun createFromParcel(parcel: Parcel): MeasurementUnit {
            return MeasurementUnit(parcel)
        }

        override fun newArray(size: Int): Array<MeasurementUnit?> {
            return arrayOfNulls(size)
        }
    }

}