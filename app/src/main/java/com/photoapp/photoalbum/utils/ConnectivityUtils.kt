package com.Rishabh Prajapati.photoalbum.utils

import android.content.Context
import android.net.ConnectivityManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.context.IContextManager


object ConnectivityUtils {

    /**
     * Check connectivity.
     * @return flag of connectivity
     */
    @Suppress("DEPRECATION")
    fun isOnline(): Boolean {
        val contextManager: IContextManager? = AddOnManager.getAddOn(AddOnType.CONTEXT_MANAGER) as IContextManager?
        val context: Context? = contextManager?.getContext()

        val connectivityManager: ConnectivityManager? = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return (connectivityManager?.activeNetworkInfo != null
                && connectivityManager.activeNetworkInfo.isAvailable
                && connectivityManager.activeNetworkInfo.isConnected)

    }
}