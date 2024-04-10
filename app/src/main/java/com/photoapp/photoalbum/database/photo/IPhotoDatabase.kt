package com.Rishabh Prajapati.photoalbum.database.photo

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo

interface IPhotoDatabase : IAddOn {
    /**
     * Get photos asynchronously.
     */
    fun getPhotos()

    /**
     * Save photos asynchronously.
     * @param photos list of photo
     */
    fun savePhotos(photos: List<Photo>)

    /**
     * Clean photos asynchronously.
     */
    fun cleanPhotos()
}