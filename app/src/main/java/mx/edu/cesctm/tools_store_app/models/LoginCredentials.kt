package mx.edu.cesctm.tools_store_app.models

import com.google.gson.annotations.SerializedName

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
data class LoginCredentials(
        @SerializedName("username") val username: String?,
        @SerializedName("password") val password: String?
)