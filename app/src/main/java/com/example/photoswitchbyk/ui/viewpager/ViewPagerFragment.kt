package com.example.photoswitchbyk.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.photoswitchbyk.R
import com.example.photoswitchbyk.data.Photo
import com.example.photoswitchbyk.databinding.FragmentViewPagerBinding
import java.util.ArrayList
/**
* kotlin null的用法
 * http://www.codedata.com.tw/kotlin/kt09/
 *
 * **/
class ViewPagerFragment : Fragment() {

    private lateinit var mViewPagerViewModel: ViewPagerViewModel
    lateinit var mViewPagerBinding: FragmentViewPagerBinding
    private lateinit var mAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewPagerBinding = DataBindingUtil.inflate<FragmentViewPagerBinding>(
            inflater,
            R.layout.fragment_view_pager,
            container,
            false
        )
        mAdapter = ViewPagerAdapter(ArrayList<Photo>())
        mViewPagerBinding.viewPager.adapter = mAdapter

        return mViewPagerBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewPagerViewModel = ViewModelProviders.of(this).get(ViewPagerViewModel::class.java!!)
        mViewPagerBinding.viewModel = mViewPagerViewModel
        mViewPagerViewModel.getPhotos().observe(this,
            Observer<ArrayList<Photo>> { photos ->
                //mAdapter.notifyDataSetChanged()
                mAdapter = ViewPagerAdapter(photos)
                mViewPagerBinding.viewPager.adapter = mAdapter
                mViewPagerBinding.viewPager.currentItem=0
            })
    }
}