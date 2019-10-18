package com.example.photoswitchbyk.ui.recyclerview;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class RecyclerViewBindings {


    @BindingAdapter("imageUrl")
    public static void bindImage(final ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//                .thumbnail(0.5f)
                .into(imageView);

//

    }
}
