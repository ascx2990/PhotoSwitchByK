package com.example.photoswitchbyk.ui.recyclerview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photoswitchbyk.data.Photo

class RecyclerViewViewModel : ViewModel() {
    private val repos = MutableLiveData<ArrayList<Photo>>().apply {
        var imgs = ArrayList<Photo>()
        var p1 = Photo()
        p1.setUrl("https://miro.medium.com/max/2463/1*9gGC8YelfY7poG9AB3lieQ.png")
        var p2 = Photo()
        p2.setUrl("https://miro.medium.com/max/1014/1*XEgA1TTwXa5AvAdw40GFow.png")
        var p3 = Photo()
        p3.setUrl("https://i1.kknews.cc/SIG=2ru26a9/ctp-vzntr/15301131549198023s8q5n0.jpg")
        for (i in 0..29) {
            imgs.add(p1)
            imgs.add(p2)
            imgs.add(p3)
        }
        Log.v("TAG","photo:"+imgs[2].getUrl())
        Log.v("TAG","photo:"+imgs[1].getUrl())
        Log.v("TAG","photo:"+imgs[0].getUrl())
        value = imgs
    }
    internal fun getPhotos(): LiveData<ArrayList<Photo>> {
        return repos
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}