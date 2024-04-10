package com.Rishabh Prajapati.photoalbum.addon

import android.content.Context
import com.Rishabh Prajapati.photoalbum.view.ViewManager
import com.Rishabh Prajapati.photoalbum.context.ContextManager
import com.Rishabh Prajapati.photoalbum.database.DatabaseManager
import com.Rishabh Prajapati.photoalbum.event.EventManager
import com.Rishabh Prajapati.photoalbum.network.queue.QueueManager
import com.Rishabh Prajapati.photoalbum.network.retrofit.RetrofitManager
import com.Rishabh Prajapati.photoalbum.network.server.ServerManager
import com.Rishabh Prajapati.photoalbum.network.service.ServiceManager
import com.Rishabh Prajapati.photoalbum.picture.PictureManager

object AddOnManager : AddOn(), IAddOnManager {

    private lateinit var mContext: Context

    override fun initialize(context: Context) {
        mContext = context
        onInitialize()
    }

    private fun onInitialize() {

        val contextManager = ContextManager(mContext)
        val activityManager = ViewManager()
        val serverManager = ServerManager()
        val serviceManager = ServiceManager()
        val eventManager = EventManager()
        val retrofitManager = RetrofitManager()
        val queueManager = QueueManager()
        val databaseManager = DatabaseManager()
        val pictureManager = PictureManager()
        // Use Vinci loader.
        pictureManager.useLoader(PictureManager.LOADER_VINCI)

        // Now assign individually.

        // Service manager.
        serviceManager.addAddOn(AddOnType.SERVER_MANAGER, serverManager)
        serviceManager.addAddOn(AddOnType.EVENT_MANAGER, eventManager)
        serviceManager.addAddOn(AddOnType.QUEUE_MANAGER, queueManager)

        // Server manager.
        serverManager.addAddOn(AddOnType.RETROFIT_MANAGER, retrofitManager)

        // Database manager.
        databaseManager.addAddOn(AddOnType.EVENT_MANAGER, eventManager)
        databaseManager.addAddOn(AddOnType.CONTEXT_MANAGER, contextManager)

        addAddOn(AddOnType.CONTEXT_MANAGER, contextManager)
        addAddOn(AddOnType.VIEW_MANAGER, activityManager)
        addAddOn(AddOnType.SERVER_MANAGER, serverManager)
        addAddOn(AddOnType.SERVICE_MANAGER, serviceManager)
        addAddOn(AddOnType.EVENT_MANAGER, eventManager)
        addAddOn(AddOnType.RETROFIT_MANAGER, retrofitManager)
        addAddOn(AddOnType.QUEUE_MANAGER, queueManager)
        addAddOn(AddOnType.DATABASE_MANAGER, databaseManager)
        addAddOn(AddOnType.PICTURE_MANAGER, pictureManager)
    }
}