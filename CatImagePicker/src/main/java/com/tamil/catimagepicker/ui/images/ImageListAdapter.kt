package com.tamil.catimagepicker.ui.images

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.tamil.catimagepicker.R
import com.tamil.domain.model.CatItem

internal class ImageListAdapter(val onItemSelected: (CatItem) -> Unit) :
    RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder>() {
    private val imageItems = ArrayList<CatItem>()
    val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)

    inner class ImageListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_image, parent, false)
        return ImageListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        Glide.with(holder.imageView).load(imageItems[position].url)
            .thumbnail(0.25f)
            .apply(requestOptions)
            .into(holder.imageView)
        holder.imageView.tag = imageItems[position]
        holder.imageView.setOnClickListener {
            onItemSelected(it.tag as CatItem)
        }
    }

    override fun getItemCount(): Int {
        return imageItems.size
    }

    fun submitItems(items: List<CatItem>) {
        val startPosition = imageItems.size - 1
        imageItems.addAll(items)
        val endPosition = imageItems.size - 1
        notifyItemRangeChanged(startPosition, endPosition)

    }

}