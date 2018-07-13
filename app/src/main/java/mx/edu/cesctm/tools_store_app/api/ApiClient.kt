package mx.edu.cesctm.tools_store_app.api

import android.content.Context
import mx.edu.cesctm.tools_store_app.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
class ApiClient{
    companion object {
        private var retrofit: Retrofit? = null
        private val CONNECT_TIMEOUT: Long = 1
        private val READ_TIMEOUT: Long = 30
        private val WRITE_TIMEOUT: Long = 15
        private const val API_ENDPOINT = "http://74.208.121.129:3001/api/"

        private val httpClient: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MINUTES)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()

        @JvmStatic
        fun getClient(context: Context): Retrofit {
            if(this.retrofit == null){
                this.retrofit = Retrofit.Builder()
                        .baseUrl(API_ENDPOINT)
                        .client(httpClient)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return  this.retrofit!!
        }
    }
}