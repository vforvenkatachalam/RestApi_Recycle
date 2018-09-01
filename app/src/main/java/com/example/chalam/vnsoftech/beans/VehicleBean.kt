package com.example.chalam.vnsoftech.beans

import com.google.gson.annotations.SerializedName

data class VehicleBean(@SerializedName("brand")
                       val brand: List<BrandItem>?)