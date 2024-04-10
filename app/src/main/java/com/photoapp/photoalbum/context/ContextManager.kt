package com.Rishabh Prajapati.photoalbum.context

import android.content.Context
import com.Rishabh Prajapati.photoalbum.addon.AddOn

class ContextManager(context: Context) : AddOn(), IContextManager {

    private var mContext: Context

    init {
        mContext = context
    }

    /**
     * Get context.
     * @param context context
     */
    override fun getContext() : Context {
        return mContext
    }
}