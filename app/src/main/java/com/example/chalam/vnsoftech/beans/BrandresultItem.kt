package com.example.chalam.vnsoftech.beans

import com.google.gson.annotations.SerializedName

data class BrandresultItem(@SerializedName("id")
                           val id: String = "",
                           @SerializedName("brand_logo")
                           val brandLogo: String = "",
                           @SerializedName("created_date")
                           val createdDate: String = "",
                           @SerializedName("brand")
                           val brand: String = "",
                           @SerializedName("brand_type")
                           val brandType: String = "")