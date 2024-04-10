package com.Rishabh Prajapati.photoalbum.feature.photolist.model

import android.text.TextUtils
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.database.IDatabaseManager
import com.Rishabh Prajapati.photoalbum.database.photo.event.PhotoDatabaseEventType
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.event.IEventManager
import com.Rishabh Prajapati.photoalbum.feature.albumlist.event.AlbumListEventType
import com.Rishabh Prajapati.photoalbum.feature.albumlist.model.Album
import com.Rishabh Prajapati.photoalbum.feature.photolist.event.PhotoListEventType
import com.Rishabh Prajapati.photoalbum.network.model.Error
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo
import com.Rishabh Prajapati.photoalbum.network.service.IServiceManager
import com.Rishabh Prajapati.photoalbum.network.service.photo.event.PhotoServiceEventType
import com.Rishabh Prajapati.photoalbum.view.BaseModel

class PhotoListModel : BaseModel() {

    private lateinit var mEventManager: IEventManager

    override fun onCreate() {
        super.onCreate()

        mEventManager = getAddOn(AddOnType.EVENT_MANAGER) as IEventManager

        // Enable receiving events.
        receiveEvents(true)
    }

    /**
     * Response with photos.
     * @param photos photos.
     * @param error error
     */
    private fun responseLoadPhotos(photos: List<Photo>, error: Error?) {
        val event = Event(PhotoListEventType.MODEL_RESPONSE_LOAD_PHOTOS, photos, error)
        mEventManager.send(event)
    }

    /**
     * Receive and handle events.
     * @param event event
     */
    @Suppress("UNCHECKED_CAST")
    override fun onReceiveEvents(event: Event) {
        if (TextUtils.equals(PhotoListEventType.MODEL_REQUEST_LOAD_PHOTOS, event.type)) {
            responseLoadPhotos((event.data as Album).photos, event.error)
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