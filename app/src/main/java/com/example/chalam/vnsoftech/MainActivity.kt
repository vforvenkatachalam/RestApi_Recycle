package com.example.chalam.vnsoftech

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.example.chalam.vnsoftech.beans.VehicleBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var resp_obj:VehicleBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = GridLayoutManager(this,2)
        var fManager:FragmentManager =this.supportFragmentManager
        var tx:FragmentTransaction = fManager.beginTransaction()

        var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://www.vehiclebuzzzz.com/").build()
        var api = r.create(VehicleAPI::class.java)
        var call = api.getVehicleInfo()

        call.enqueue(object:Callback<VehicleBean>{
            override fun onFailure(call: Call<VehicleBean>?, t: Throwable?) {
                Toast.makeText(this@MainActivity,"Fail..!",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<VehicleBean>?, response: Response<VehicleBean>?) {
                var res = response!!.body()
                this@MainActivity.resp_obj = response!!.body()
    //Toast.makeText(this@MainActivity,resp_obj.toString(),Toast.LENGTH_LONG).show()
                recyclerview.adapter = RecycleAdapter(this@MainActivity,res!!,tx)
            }

        })
    }
}
