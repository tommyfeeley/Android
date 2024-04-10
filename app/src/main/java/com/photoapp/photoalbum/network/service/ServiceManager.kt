package com.Rishabh Prajapati.photoalbum.network.service

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import com.Rishabh Prajapati.photoalbum.network.service.photo.IPhotoService
import com.Rishabh Prajapati.photoalbum.network.service.photo.PhotoService

class ServiceManager : AddOn(), IServiceManager {

    private val mPhotoService: IPhotoService by lazy {
        val photoService = PhotoService()
        photoService.addAddOns(getAddOns())
        photoService
    }

    /**
     * Get photo service.
     * @return photo service
     */
    override fun getPhotoService(): IPhotoService {
        return mPhotoService
    }

    /**
     * Clear addons.
     */
    override fun clearAddOns() {
        mPhotoService.clearAddOns()
        super.clearAddOns()
    }
}