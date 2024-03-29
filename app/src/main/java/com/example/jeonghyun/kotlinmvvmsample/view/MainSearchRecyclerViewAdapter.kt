package com.example.jeonghyun.kotlinmvvmsample.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jeonghyun.kotlinmvvmsample.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main_image.view.*

class MainSearchRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val imageItemList = ArrayList<ImageItem>()

    data class ImageItem(var imageUrl: String, var documentUrl: String)

    class ImageHolder(parent:ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_main_image, parent, false)
    ) {
        fun onBind(item: ImageItem){
            itemView.run {
                Picasso.with(context).load(item.imageUrl).placeholder(R.drawable.ic_image_black_24dp).into(item_main_image_view)
                item_main_image_view.setOnClickListener {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.documentUrl)), null)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageHolder(parent)

    override fun getItemCount() = imageItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageHolder)?.onBind(imageItemList[position])
    }

    fun addImageItem(imageUrl: String, documentUrl: String){
        imageItemList.add(ImageItem(imageUrl, documentUrl))
    }
}