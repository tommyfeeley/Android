package com.Rishabh Prajapati.photoalbum.database.photo

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.database.photo.event.PhotoDatabaseEventType
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.event.IEventManager
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo
import com.Rishabh Prajapati.photoalbum.utils.CoroutineUtils
import com.squareup.sqldelight.Query
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PhotoDatabase(val db: PhotoDB) : AddOn(), IPhotoDatabase {

    /**
     * Get photos asynchronously.
     */
    override fun getPhotos() {
        GlobalScope.launch(CoroutineUtils.DISPATCHER_IO) {
            var photos: ArrayList<Photo> = arrayListOf()

            val photoTableQueries: Query<PhotoTable> = db.photoTableQueries.selectAll()
            photoTableQueries.executeAsList().forEach { photoQuery ->

                val photo = Photo(
                    photoQuery.albumId,
                    photoQuery.id,
                    photoQuery.title,
                    photoQuery.url,
                    photoQuery.thumbnailUrl
                )
                photos.add(photo)
            }

            val event = Event(PhotoDatabaseEventType.GET_PHOTOS, photos, null)
            val eventManager: IEventManager? = getAddOn(AddOnType.EVENT_MANAGER) as IEventManager?
            eventManager?.send(event)
        }
    }

    /**
     * Save photos asynchronously.
     * @param photos list of photo
     */
    override fun savePhotos(photos: List<Photo>) {
        GlobalScope.launch(CoroutineUtils.DISPATCHER_IO) {
            photos.forEach { photo ->
                db.photoTableQueries.insert(
                    photo.albumId,
                    photo.id!!,
                    photo.title,
                    photo.url,
                    photo.thumbnailUrl
                )
            }

            val event = Event(PhotoDatabaseEventType.SAVE_PHOTOS, photos, null)
            val eventManager: IEventManager? = getAddOn(AddOnType.EVENT_MANAGER) as IEventManager?
            eventManager?.send(event)
        }
    }

    /**
     * Clean photos asynchronously.
     */
    override fun cleanPhotos() {
        GlobalScope.launch(CoroutineUtils.DISPATCHER_IO) {
            db.photoTableQueries.deleteAll()

            val event = Event(PhotoDatabaseEventType.CLEAN_PHOTOS, null, null)
            val eventManager: IEventManager? = getAddOn(AddOnType.EVENT_MANAGER) as IEventManager?
            eventManager?.send(event)
        }
    }
}