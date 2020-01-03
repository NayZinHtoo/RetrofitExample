package com.nzh.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nzh.retrofitexample.mode.Region
import com.ucsmonywataungthu.org.Network.APIClient
import com.ucsmonywataungthu.org.Network.APIService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var apiService: APIService = APIClient.client.create((APIService::class.java))
    var regionList:List<Region>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call=apiService.getRegion()
        call.enqueue(object :retrofit2.Callback<List<Region>>{
            override fun onFailure(call: Call<List<Region>>, t: Throwable) {
            }
            override fun onResponse(call: Call<List<Region>>, response: Response<List<Region>>) {
                regionList=response.body()

                regionList!!.forEach {
                    Log.i("Fetch Data","Id : ${it.id}")
                    Log.i("Fetch Data","Id : ${it.region_name}")
                }
                Log.i("Region Size ::",regionList!!.size.toString())
            }
        })
    }
}
