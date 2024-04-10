package com.Rishabh Prajapati.photoalbum.feature.photolist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.feature.photolist.listener.IPhotoListListener
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo


class PhotoListAdapter(val photos: MutableList<Photo>, val listener: IPhotoListListener) : RecyclerView.Adapter<PhotoListViewHolder>() {

    companion object {
        const val SPAN_SIZE: Int = 3
        private const val SEPARATOR_SIZE: Int = 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_item, parent, false)

        val layoutParams = view.getLayoutParams() as GridLayoutManager.LayoutParams
        layoutParams.width = (parent.measuredWidth - (SEPARATOR_SIZE * 2)) / SPAN_SIZE
        layoutParams.height = layoutParams.width
        view.setLayoutParams(layoutParams)

        return PhotoListViewHolder(
            view,
            listener
        )
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoListViewHolder, index: Int) {
        val photo: Photo = photos.get(index)

        val layoutParams = holder.itemView.getLayoutParams() as GridLayoutManager.LayoutParams

        val column = index % SPAN_SIZE

        var marginLeft = 0
        var marginRight = 0
        var marginTop = 0

        // Left.
        if (column == 0) {
            marginRight = SEPARATOR_SIZE / 2
        } else if (column == 1) {
            marginLeft = SEPARATOR_SIZE / 2
            marginRight = SEPARATOR_SIZE / 2
        } else {
            marginLeft = SEPARATOR_SIZE / 2
        }

        if (index >= SPAN_SIZE) {
            marginTop =
                SEPARATOR_SIZE
        }

        layoutParams.setMargins(marginLeft, marginTop, marginRight, 0)

        holder.bind(photo)
    }
}