package com.example.sipaten_pln.network

import com.example.sipaten_pln.model.response.Wrapper
import com.example.sipaten_pln.model.response.amr.AmrResponse
import com.example.sipaten_pln.model.response.gantimeter.Data
import com.example.sipaten_pln.model.response.gantimeter.GantiMeterResponse
import com.example.sipaten_pln.model.response.login.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface EndPoint {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,
              @Field("password") password:String) : Observable<Wrapper<LoginResponse>>

    @GET("gantimeter")
    fun gantimeter() : Observable<Wrapper<GantiMeterResponse>>

    @PUT("gantimeter/{id}")
    fun updateGantiMeter(
        @Path("id") id: Int,
        @Body data: Data // Ganti Data dengan tipe data yang sesuai
    ): Observable<Wrapper<GantiMeterResponse>>


    @GET("amr")
    fun amr() : Observable<Wrapper<AmrResponse>>

    @PUT("amr/{id}")
    fun updateamr(
        @Path("id") id: Int,
        @Body data: com.example.sipaten_pln.model.response.amr.Data  // Ganti Data dengan tipe data yang sesuai
    ): Observable<Wrapper<AmrResponse>>


}
