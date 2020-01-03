package com.ucsmonywataungthu.org.Network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient  {

    companion object {
        val BASE_URL = "https://taungthu.000webhostapp.com/api/"
        var retrofit: Retrofit? = null
        val client: Retrofit
            get() {
                if (retrofit == null) {

                    val okHttpClient = OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .build()

                    val gson = GsonBuilder()
                        .setLenient()
                        .create()

                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                }
                return retrofit!!
            }
    }
}