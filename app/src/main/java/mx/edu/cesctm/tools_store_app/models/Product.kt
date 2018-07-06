package mx.edu.cesctm.tools_store_app.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
data class Product(
        @SerializedName("product_id") val mId: Int?,
        @SerializedName("description") val mDescription: String?,
        @SerializedName("unit_price") val mUnitPrice: Double?,
        @SerializedName("stock") val mStock: Double?,
        @SerializedName("measurement_unit") val mMeasurementUnit: MeasurementUnit?
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readValue(Double::class.java.classLoader) as? Double,
            parcel.readValue(Double::class.java.classLoader) as? Double,
            parcel.readParcelable(MeasurementUnit::class.java.classLoader)) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            dest.writeValue(mId)
            dest.writeString(mDescription)
            dest.writeValue(mUnitPrice)
            dest.writeValue(mStock)
            dest.writeParcelable(mMeasurementUnit,flags)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

}