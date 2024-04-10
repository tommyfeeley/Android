package com.Rishabh Prajapati.photoalbum.network.server

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import com.Rishabh Prajapati.photoalbum.network.server.photo.IPhotoServer

interface IServerManager : IAddOn {
    /**
     * Get photo server.
     * @return photo server
     */
    fun getPhotoServer() : IPhotoServer
}