package com.Rishabh Prajapati.photoalbum.network.service

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import com.Rishabh Prajapati.photoalbum.network.service.photo.IPhotoService

interface IServiceManager : IAddOn {
    /**
     * Get photo service.
     * @return photo service
     */
    fun getPhotoService() : IPhotoService
}