package com.example.chalam.vnsoftech

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.chalam.vnsoftech.beans.VehicleBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.indiv_view.view.*

class Second_RecycleAdapter:RecyclerView.Adapter<myHolder> {
    var data:VehicleBean?=null
    var myActivity:SecondActivity? = null
    var brand_Name:MutableList<String> = mutableListOf()
    var brand_Logo:MutableList<String> = mutableListOf()
    constructor(myActivity: SecondActivity,key:String,data:VehicleBean)
    {
        this.myActivity = myActivity
        this.data = data

        for(x in data!!.brand!!)
        {
            if(x.category.equals(key)) {
                for (y in x.brandresult!!) {
                    brand_Name.add(y.brand)
                    brand_Logo.add(y.brandLogo)
                }
            }
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myHolder {
        var view:View = LayoutInflater.from(myActivity).inflate(R.layout.indiv_view,p0,false)
        return myHolder(view)
    }

    override fun getItemCount(): Int {
        return brand_Name.size
    }

    override fun onBindViewHolder(p0: myHolder, p1: Int) {
        p0.textView!!.text = brand_Name[p1]
        Picasso.get().load(brand_Logo[p1]).into(p0.imageView)
        Toast.makeText(myActivity,brand_Logo[p1],Toast.LENGTH_LONG).show()
    }
}
class myHolder:RecyclerView.ViewHolder{

    var imageView:ImageView? = null
    var textView:TextView? = null
    constructor(v: View) : super(v)
    {
        imageView = v.brand
        textView = v.brandName
    }
}