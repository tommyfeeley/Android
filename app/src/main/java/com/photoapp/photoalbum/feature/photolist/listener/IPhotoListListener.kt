package com.Rishabh Prajapati.photoalbum.feature.photolist.listener

import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo

interface IPhotoListListener {
    fun onClickPhoto(photo: Photo)
}