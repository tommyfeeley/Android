package com.Rishabh Prajapati.photoalbum.utils

import android.content.Context
import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.context.IContextManager
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

object PicassoUtils {

    val mPicasso: Picasso by lazy {
        val contextManager: IContextManager? = AddOnManager.getAddOn(AddOnType.CONTEXT_MANAGER) as IContextManager?
        val context: Context? = contextManager?.getContext()
        val builder = Picasso.Builder(context!!)
        // Maximize cache.
        builder.downloader(OkHttp3Downloader(context, Long.MAX_VALUE))
        val built = builder.build()
        Picasso.setSingletonInstance(built)
        Picasso.get()
    }

    /**
     * Get picasso instance.
     * @return instance of picasso.
     */
    fun getPicasso() : Picasso {
        return mPicasso
    }
}