package com.example.photoswitchbyk.ui.viewpager

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.photoswitchbyk.data.Photo
import com.example.photoswitchbyk.databinding.ItemPhotoBinding
import java.util.*

/**
 * Any類似Java中的Object，Object是Java中所有類別的父類別。
 * */
class ViewPagerAdapter() : PagerAdapter() {


    private var TAG = ViewPagerAdapter::class.java.simpleName
    private lateinit var items: ArrayList<Photo>
    private lateinit var mViewCache: LinkedList<View>

    constructor(items: ArrayList<Photo>) : this() {
        this.items = items
        this.mViewCache = LinkedList<View>()
        Log.v(TAG,"constructor")

    }

    internal inner class PhotosViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.data = photo
            binding.executePendingBindings()
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var viewHolder: PhotosViewHolder? = null
        var convertView: View? = null
        if (items.size <= 0) {
            return null!!
        }
        if (mViewCache.size == 0) {
            val layoutInflater = LayoutInflater.from(container.context)
            val binding = ItemPhotoBinding.inflate(layoutInflater, container, false)
            viewHolder = PhotosViewHolder(binding)
            convertView= binding.root
            convertView.setTag(viewHolder)
        } else {
            convertView = mViewCache.removeFirst()
            viewHolder = convertView.tag as PhotosViewHolder
        }
        val photo = items[position]
        //Log.v(TAG, "photo:" + photo.getUrl())
        viewHolder.bind(photo)
        container.addView(
            convertView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return convertView!!

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)
        val contentView = `object` as View
        container.removeView(contentView)
        this.mViewCache.add(contentView)
    }
    override fun getCount(): Int {
        Log.v(TAG,"size:"+items.size)
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

}