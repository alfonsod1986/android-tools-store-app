package mx.edu.cesctm.tools_store_app.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
data class Company(
        @SerializedName("company_id") val mId: Int?,
        @SerializedName("business_name") val mBusinessName: String?,
        @SerializedName("rfc") val mRfc: String?,
        @SerializedName("address") val mAddress: String?,
        @SerializedName("neigborhood") val mNeigborhood: String?,
        @SerializedName("country") val mCountry: String?,
        @SerializedName("state") val mState: String?,
        @SerializedName("city") val mCity: String?,
        @SerializedName("zipcode") val mZipCode: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            dest.writeValue(mId)
            dest.writeString(mBusinessName)
            dest.writeString(mRfc)
            dest.writeString(mAddress)
            dest.writeString(mNeigborhood)
            dest.writeString(mCountry)
            dest.writeString(mState)
            dest.writeString(mCity)
            dest.writeString(mZipCode)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Company> {
        override fun createFromParcel(parcel: Parcel): Company {
            return Company(parcel)
        }

        override fun newArray(size: Int): Array<Company?> {
            return arrayOfNulls(size)
        }
    }

}