package com.example.chalam.vnsoftech

import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.chalam.vnsoftech.beans.VehicleBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.indiv_view.view.*

class RecycleAdapter: RecyclerView.Adapter<RecycleHolder> {

    var myActivity:MainActivity
    var data:VehicleBean
    var category:MutableList<String> = mutableListOf()
    var image:MutableList<String> = mutableListOf()
    var cardView:CardView? = null
    var tx:FragmentTransaction? = null
    var frag = FragmentMain()
    var sec = SecondActivity()

    constructor(myActivity: MainActivity,data:VehicleBean,tx:FragmentTransaction)
    {
        this.tx = tx

        this.myActivity = myActivity
        this.data = data
        for (x in data.brand!!)
        {
            category.add(x.category)
            image.add(x.icon)
            Log.i("msg",x.category)
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecycleHolder {
        var view:View = LayoutInflater.from(myActivity).inflate(R.layout.indiv_view,p0,false)
        cardView = view.findViewById(R.id.cardview)

        sec.data = data
        return RecycleHolder(view)
    }

    override fun getItemCount(): Int {
        return category!!.size
    }

    override fun onBindViewHolder(p0: RecycleHolder, p1: Int) {

        p0.textView!!.text = category[p1]
        Picasso.get().load(image[p1])

        p0.imageview!!.setOnClickListener({
            var intent = Intent(myActivity,SecondActivity::class.java)
            intent.putExtra("category",category[p1])
            startActivity(myActivity,intent,null)
        })
        cardView!!.setOnClickListener({

            var intent = Intent(myActivity,SecondActivity::class.java)
            intent.putExtra("category",category[p1])
            startActivity(myActivity,intent,null)
        })
    }

}
class RecycleHolder: RecyclerView.ViewHolder {

    var imageview:ImageView?=null
    var textView:TextView?=null

    constructor(v:View) : super(v)
    {
        imageview = v.brand
        textView = v.brandName
    }

}