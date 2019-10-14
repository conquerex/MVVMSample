package com.meme.hwapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.meme.hwapp.base.BaseViewModel
import com.meme.hwapp.response.ImagesResponse

/**
 * LiveData의 내부 접근을 막기 위해 private으로 선언 후 별도의 변수에 getter로 할당
 */
class MainViewModel : BaseViewModel() {

    var liveData = MutableLiveData<ImagesResponse>()
    var repository = MainRepository()

    init {
        liveData = repository.getImages()
    }

    fun setData(res: ImagesResponse) {
        liveData.value = res
    }

    fun getImgaesData(): MutableLiveData<ImagesResponse> {
        if (liveData.value != null) {
            Log.d("MainViewModel", "* * * ${liveData.value!!.photos.page}")
        }
        return liveData
    }

    fun getPageCount(): String {
        Log.d("MainViewModel", "* * * 1")
        if (liveData.value == null) {
            Log.d("MainViewModel", "* * * 2")
            return "0"
        }
        return liveData.value!!.photos.page
    }
}