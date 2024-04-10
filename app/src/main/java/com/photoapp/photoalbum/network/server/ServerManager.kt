package com.Rishabh Prajapati.photoalbum.network.server

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import com.Rishabh Prajapati.photoalbum.network.server.photo.IPhotoServer
import com.Rishabh Prajapati.photoalbum.network.server.photo.PhotoServer

class ServerManager : AddOn(), IServerManager {

    private val mPhotoServer: IPhotoServer by lazy {
        val photoServer = PhotoServer()
        photoServer.addAddOns(getAddOns())
        photoServer
    }

    /**
     * Get photo server.
     * @return photo server
     */
    override fun getPhotoServer(): IPhotoServer {
        return mPhotoServer
    }

    /**
     * Clear addons.
     */
    override fun clearAddOns() {
        mPhotoServer.clearAddOns()
        super.clearAddOns()
    }
}