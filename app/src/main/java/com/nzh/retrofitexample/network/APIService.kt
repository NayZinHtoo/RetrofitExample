package com.ucsmonywataungthu.org.Network


import com.nzh.retrofitexample.mode.Region
import retrofit2.Call
import retrofit2.http.*

interface APIService  {

    @GET("region")
    fun getRegion():Call<List<Region>>
}