package com.meme.hwapp

import android.util.Log
import androidx.lifecycle.LiveData
import com.meme.hwapp.network.ApiRequest
import com.meme.hwapp.network.NetworkSetting
import androidx.lifecycle.MutableLiveData
import com.meme.hwapp.response.ImagesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    var apiRequest: ApiRequest

    constructor() {
        apiRequest = NetworkSetting.getClient().create(ApiRequest::class.java)
    }

    fun getImages(): MutableLiveData<ImagesResponse> {
        val data = MutableLiveData<ImagesResponse>()

        apiRequest.getImages().enqueue(object: Callback<ImagesResponse> {
            override fun onFailure(call: Call<ImagesResponse>, t: Throwable) {
                Log.d("MainRepository", "* * * onFailure")
                Log.d("MainRepository", "* * * ${t.message}")
            }

            override fun onResponse(call: Call<ImagesResponse>, response: Response<ImagesResponse>) {
                Log.d("MainRepository", "* * * onResponse")
                data.value = response.body()
            }
        })

        return data
    }

}