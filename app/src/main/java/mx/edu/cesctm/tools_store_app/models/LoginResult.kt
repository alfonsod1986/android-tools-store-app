package mx.edu.cesctm.tools_store_app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
data class LoginResult(
        @SerializedName("success") @Expose val success: Boolean?,
        @SerializedName("user") @Expose val user: User?
)