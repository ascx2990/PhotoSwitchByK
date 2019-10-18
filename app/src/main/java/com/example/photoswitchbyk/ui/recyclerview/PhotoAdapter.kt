package com.example.photoswitchbyk.ui.recyclerview


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoswitchbyk.data.Photo
import com.example.photoswitchbyk.databinding.ItemPhotoBinding

/**
 *private：只能在宣告的檔案中使用
 *internal：只能在同一個模組中使用
 *public：可以在應用程式任何地方使用
 *
 *
 * 多了inner關鍵字，就可以使用最外層類別的屬性與函式
 */
internal class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotosViewHolder> {
    private var TAG = PhotoAdapter::class.java.simpleName

    private var items: ArrayList<Photo>

    constructor(items: ArrayList<Photo>) : super() {
        this.items = items

    }

    override fun getItemCount(): Int {

        //Log.v(TAG,"size:"+items.size)
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {

        val photo = items[position]
        Log.v(TAG, "photo:" + photo.getUrl())
        holder.bind(photo)
    }

    //注意一下是否會取不到binding
    internal inner class PhotosViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.data = photo
            binding.executePendingBindings()
        }
    }


}