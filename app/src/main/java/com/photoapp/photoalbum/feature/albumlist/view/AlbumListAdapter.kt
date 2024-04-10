package com.Rishabh Prajapati.photoalbum.feature.albumlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.feature.albumlist.listener.IAlbumListListener
import com.Rishabh Prajapati.photoalbum.feature.albumlist.model.Album


class AlbumListAdapter(val albums: MutableList<Album>, val listener: IAlbumListListener) : RecyclerView.Adapter<AlbumListViewHolder>() {

    companion object {
        const val SPAN_SIZE: Int = 2
        private const val SEPARATOR_SIZE: Int = 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_album_item, parent, false)

        val layoutParams = view.getLayoutParams() as GridLayoutManager.LayoutParams
        layoutParams.width = (parent.measuredWidth - SEPARATOR_SIZE) / SPAN_SIZE
        layoutParams.height = layoutParams.width
        view.setLayoutParams(layoutParams)

        return AlbumListViewHolder(
            view,
            listener
        )
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumListViewHolder, index: Int) {
        val album: Album = albums.get(index);

        val layoutParams = holder.itemView.getLayoutParams() as GridLayoutManager.LayoutParams

        val column = index % 2

        var marginLeft = 0
        var marginRight = 0
        var marginTop = 0

        // Left.
        if (column == 0) {
            marginRight = SEPARATOR_SIZE / 2
        } else {
            marginLeft = SEPARATOR_SIZE / 2
        }

        if (index >= SPAN_SIZE) {
            marginTop =
                SEPARATOR_SIZE
        }

        layoutParams.setMargins(marginLeft, marginTop, marginRight, 0)

        holder.bind(album)
    }
}