package mx.edu.cesctm.tools_store_app.utils

import android.content.Context
import android.widget.Toast

object UiUtils{
    fun showToast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(context, message, length).show()
    }

}