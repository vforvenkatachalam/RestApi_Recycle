package com.example.chalam.vnsoftech.beans

import com.google.gson.annotations.SerializedName

data class BrandItem(@SerializedName("createddate")
                     val createddate: String = "",
                     @SerializedName("icon")
                     val icon: String = "",
                     @SerializedName("brandresult")
                     val brandresult: List<BrandresultItem>?,
                     @SerializedName("id")
                     val id: String = "",
                     @SerializedName("category")
                     val category: String = "",
                     @SerializedName("setorder")
                     val setorder: String = "")