package com.Rishabh Prajapati.photoalbum.network.server.photo

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.network.retrofit.IRetrofitManager

class PhotoServer : AddOn(), IPhotoServer {
    // Photo calls.
    private val mPhotoCall : IPhotoCall by lazy {
        val retrofitManager: IRetrofitManager = getAddOn(AddOnType.RETROFIT_MANAGER) as IRetrofitManager
        retrofitManager.getRetrofit().create(IPhotoCall::class.java)
    }

    /**
     * Get photo calls.
     * @return photo calls
     */
    override fun getPhotoCall() : IPhotoCall {
        return mPhotoCall
    }
}