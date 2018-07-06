package mx.edu.cesctm.tools_store_app.api

import io.reactivex.Single
import mx.edu.cesctm.tools_store_app.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * @author Luis Alfonso Delgado Ballado
 * @version 1.0.0
 * @since Tue , 06/26/2018
 */
interface ApiToolsStoreApp{
    /* Log In */
    @POST("auth")
    fun auth(@Body credentials: LoginCredentials): Single<Response<LoginResult>>

    /* Companies*/
    @GET("companies")
    fun getAllCompanies(): Single<Response<List<Company>>>

    @GET("companies/{companyId}")
    fun getCompanyById(@Path("companyId") companyId: Int): Single<Response<List<Company>>>

    //----------------------------------------------------------------------------------------------
    /* Customers */
    @GET("customers")
    fun getAllCustomers(): Single<Response<List<Customer>>>

    @GET("customers/{customerId}")
    fun getCustomerById(@Path("customerId") customerId: Int): Single<Response<List<Customer>>>

    //----------------------------------------------------------------------------------------------
    /* Measurement Units */
    @GET("measurement_units")
    fun getAlMeasurementUnits(): Single<Response<List<MeasurementUnit>>>

    @GET("measurement_units/{measurementUnitId}")
    fun getMeasurementUnitById(@Path("measurementUnitId") measurementUnitId: Int): Single<Response<List<MeasurementUnit>>>

    //----------------------------------------------------------------------------------------------
    /* Products */
    @GET("products")
    fun getAllProducts(): Single<Response<List<Product>>>

    @GET("products/{productId}")
    fun getProductById(@Path("productId") productId: Int): Single<Response<List<Product>>>
}