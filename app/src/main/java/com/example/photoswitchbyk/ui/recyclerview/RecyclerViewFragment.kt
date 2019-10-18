package com.example.photoswitchbyk.ui.recyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photoswitchbyk.R
import com.example.photoswitchbyk.data.Photo
import com.example.photoswitchbyk.databinding.FragmentRecyclerviewBinding
import kotlin.collections.ArrayList

class RecyclerViewFragment : Fragment() {
    private var TAG = RecyclerViewFragment::class.java.simpleName
    private lateinit var mViewModel: RecyclerViewViewModel
    lateinit var mRecyclerviewBinding: FragmentRecyclerviewBinding
    private lateinit var mAdapter: PhotoAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRecyclerviewBinding = DataBindingUtil.inflate<FragmentRecyclerviewBinding>(
            inflater,
            R.layout.fragment_recyclerview,
            container,
            false
        )
        //mRecyclerviewBinding = FragmentRecyclerviewBinding.inflate(inflater, container, false)
        mAdapter = PhotoAdapter(ArrayList<Photo>())
        mRecyclerviewBinding.recyclerView.adapter = mAdapter
        val layout = LinearLayoutManager(context)
        layout.orientation = LinearLayoutManager.HORIZONTAL
        mRecyclerviewBinding.recyclerView.layoutManager = layout

        return mRecyclerviewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.v(TAG, "onActivityCreated")
        mViewModel = ViewModelProviders.of(this).get(RecyclerViewViewModel::class.java!!)
        mRecyclerviewBinding.viewModel = mViewModel
        mViewModel.getPhotos().observe(this,
            Observer<ArrayList<Photo>> { photos ->
                //mAdapter.notifyDataSetChanged()
                mAdapter = PhotoAdapter(photos)
                mRecyclerviewBinding.recyclerView.adapter = mAdapter
            })

    }
//    private fun creatData() :ArrayList<Photo>{
//        var imgs = ArrayList<Photo>()
//        var p1 = Photo()
//        p1.setUrl("https://miro.medium.com/max/2463/1*9gGC8YelfY7poG9AB3lieQ.png")
//        var p2 = Photo()
//        p2.setUrl("https://miro.medium.com/max/2463/1*9gGC8YelfY7poG9AB3lieQ.png")
//        var p3 = Photo()
//        p3.setUrl("https://miro.medium.com/max/2463/1*9gGC8YelfY7poG9AB3lieQ.png")
//        for (i in 0..29) {
//            imgs.add(p1)
//            imgs.add(p2)
//            imgs.add(p3)
//        }
//        return imgs
//    }
}


