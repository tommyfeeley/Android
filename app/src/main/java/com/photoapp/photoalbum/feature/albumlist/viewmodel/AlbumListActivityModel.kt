package com.Rishabh Prajapati.photoalbum.feature.albumlist.viewmodel

import android.text.TextUtils
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.view.BaseViewModel
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.event.IEventManager
import com.Rishabh Prajapati.photoalbum.feature.albumlist.event.AlbumListEventType
import com.Rishabh Prajapati.photoalbum.feature.albumlist.model.Album
import com.Rishabh Prajapati.photoalbum.feature.albumlist.model.AlbumListModel
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo

class AlbumListActivityModel : BaseViewModel() {

    private lateinit var mEventManager: IEventManager

    override fun onCreate() {
        super.onCreate()

        setModel(AlbumListModel::class.java)

        mEventManager = getAddOn(AddOnType.EVENT_MANAGER) as IEventManager

        // Enable receiving events.
        receiveEvents(true)
    }

    /**
     * Update loader
     * @param show flag
     */
    private fun updateLoader(show: Boolean) {
        val event = Event(AlbumListEventType.VIEW_UPDATE_LOADER, show, null)
        mEventManager.send(event)
    }

    /**
     * Update message.
     * @param message message
     */
    private fun updateMessage(message: Any?) {
        val event = Event(AlbumListEventType.VIEW_UPDATE_MESSAGE, message, null)
        mEventManager.send(event)
    }

    /**
     * Request to load albums.
     */
    fun requestLoadAlbums() {
        // Show loader.
        updateLoader(true)

        // Load albums.
        val event = Event(AlbumListEventType.MODEL_REQUEST_LOAD_ALBUMS, null, null)
        mEventManager.send(event)
    }

    /**
     * Response with albums.
     * @param photoList albums.
     */
    private fun responseLoadAlbums(albums: List<Album>?) {
        val event = Event(AlbumListEventType.VIEWMODEL_RESPONSE_LOAD_ALBUMS, albums, null)
        mEventManager.send(event)
    }

    /**
     * Receive and handle events.
     * @param event event
     */
    @Suppress("UNCHECKED_CAST")
    override fun onReceiveEvents(event: Event) {
        if (TextUtils.equals(AlbumListEventType.VIEWMODEL_REQUEST_LOAD_ALBUMS, event.type)) {
            requestLoadAlbums()
        } else if (TextUtils.equals(AlbumListEventType.MODEL_RESPONSE_LOAD_ALBUMS, event.type)) {
            // Hide loader.
            updateLoader(false)

            if (event.error != null) {
                // Show message.
                updateMessage(R.string.albumlist_error_load)
            } else {
                // Send reponse.
                responseLoadAlbums(event.data as List<Album>?)
            }
        }
    }

    /**
     * On destroy, clean.
     */
    override fun onDestroy() {
        // Disable receiving events.
        receiveEvents(false)
        super.onDestroy()
    }
}