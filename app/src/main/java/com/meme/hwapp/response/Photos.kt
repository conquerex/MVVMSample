package com.meme.hwapp.response

import com.google.gson.annotations.SerializedName

data class Photos (
	@SerializedName("page") val page : String,
	@SerializedName("pages") val pages : Int,
	@SerializedName("perpage") val perpage : Int,
	@SerializedName("total") val total : Int,
	@SerializedName("photo") val photo : List<Photo>
)