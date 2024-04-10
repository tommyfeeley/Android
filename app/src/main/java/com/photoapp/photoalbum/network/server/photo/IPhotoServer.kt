package com.Rishabh Prajapati.photoalbum.network.server.photo

import com.Rishabh Prajapati.photoalbum.addon.IAddOn

interface IPhotoServer : IAddOn {
    /**
     * Get photo call.
     * @return photo call
     */
    fun getPhotoCall() : IPhotoCall
}