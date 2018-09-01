package com.example.chalam.vnsoftech

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.chalam.vnsoftech.beans.VehicleBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity: AppCompatActivity() {

    /*var fm:FragmentManager = supportFragmentManager
    var frag0:FragmentMain = FragmentMain()*/

    var myactivity:MainActivity = MainActivity()
    var data:VehicleBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://www.vehiclebuzzzz.com/").build()
        var api = r.create(VehicleAPI::class.java)
        var call = api.getVehicleInfo()

        var intent:Intent = intent
        val str = intent.getStringExtra("category")

        call.enqueue(object: Callback<VehicleBean> {
            override fun onFailure(call: Call<VehicleBean>?, t: Throwable?) {
                Toast.makeText(this@SecondActivity,"Fail..!",Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<VehicleBean>?, response: Response<VehicleBean>?) {
                var res = response!!.body()
                //Toast.makeText(this@MainActivity,resp_obj.toString(),Toast.LENGTH_LONG).show()
                second_recyclerview.layoutManager = GridLayoutManager(this@SecondActivity,2)
                second_recyclerview.adapter = Second_RecycleAdapter(this@SecondActivity,str,res!!)
            }
        })
    }
}