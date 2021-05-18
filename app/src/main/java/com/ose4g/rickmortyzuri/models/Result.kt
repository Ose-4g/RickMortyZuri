package com.ose4g.rickmortyzuri.models

import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("id")
    var id:Long? = null

    @SerializedName("name")
    var names:String? = null

    @SerializedName("status")
    var status:String? = null

    @SerializedName("species")
    var species:String? = null

    @SerializedName("image")
    var image:String? = null
}