package mx.edu.cesctm.tools_store_app.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
data class User(
        @SerializedName("dni") val mId: Int?,
        @SerializedName("username") val mUsername: String?,
        @SerializedName("first_name") val mFirstName: String?,
        @SerializedName("last_name") val mLastName: String?,
        @SerializedName("second_name") val mSecondName: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            dest.writeValue(mId)
            dest.writeString(mUsername)
            dest.writeString(mFirstName)
            dest.writeString(mLastName)
            dest.writeString(mSecondName)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}