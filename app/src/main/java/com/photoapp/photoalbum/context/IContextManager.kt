package com.Rishabh Prajapati.photoalbum.context

import android.content.Context
import com.Rishabh Prajapati.photoalbum.addon.IAddOn

interface IContextManager : IAddOn {
    /**
     * Get context.
     * @param context context
     */
    fun getContext() : Context
}