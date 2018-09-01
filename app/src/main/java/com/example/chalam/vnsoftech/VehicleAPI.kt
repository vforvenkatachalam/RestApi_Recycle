package com.example.chalam.vnsoftech

import com.example.chalam.vnsoftech.beans.VehicleBean
import retrofit2.Call
import retrofit2.http.GET

interface VehicleAPI {

    @GET("index.php/JsonController/brand")
    fun getVehicleInfo():Call<VehicleBean>
}