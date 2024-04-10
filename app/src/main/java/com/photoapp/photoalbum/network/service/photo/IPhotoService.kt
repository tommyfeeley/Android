package com.Rishabh Prajapati.photoalbum.network.service.photo

import com.Rishabh Prajapati.photoalbum.addon.IAddOn

interface IPhotoService : IAddOn {
    /**
     * Get photos asynchronously.
     */
    fun getPhotos()
}