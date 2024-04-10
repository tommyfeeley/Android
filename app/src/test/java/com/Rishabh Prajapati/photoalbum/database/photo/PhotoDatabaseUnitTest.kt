package com.Rishabh Prajapati.photoalbum.database.photo

import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.core.BaseUnitTest
import com.Rishabh Prajapati.photoalbum.database.IDatabaseManager
import com.Rishabh Prajapati.photoalbum.database.photo.event.PhotoDatabaseEventType
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.event.IEventManager
import com.Rishabh Prajapati.photoalbum.utils.UnitDummyUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.asserter

class PhotoDatabaseUnitTest : BaseUnitTest() {

    @Test
    /**
     * Get photos.
     */
    fun getPhotos() = runBlocking {
        var e: Event? = null

        val eventManager: IEventManager = AddOnManager.getAddOn(AddOnType.EVENT_MANAGER) as IEventManager
        val databaseManager: IDatabaseManager = AddOnManager.getAddOn(AddOnType.DATABASE_MANAGER) as IDatabaseManager

        eventManager.subscribe(callback = { event: Event -> Unit
            if (event.type.equals(PhotoDatabaseEventType.GET_PHOTOS)) {
                e = event
            } else if (event.type.equals(PhotoDatabaseEventType.SAVE_PHOTOS)) {
                databaseManager.getPhotoDatabase().getPhotos()
            }
        })

        databaseManager.getPhotoDatabase().savePhotos(UnitDummyUtils.createDummyPhotos())

        delay(DELAY_AVERAGE)
        asserter.assertTrue("getPhotos", e != null && e!!.data != null && e!!.error == null)
    }

    @Test
    /**
     * Save photos.
     */
    fun savePhotos() = runBlocking {
        var e: Event? = null

        val eventManager: IEventManager = AddOnManager.getAddOn(AddOnType.EVENT_MANAGER) as IEventManager
        val databaseManager: IDatabaseManager = AddOnManager.getAddOn(AddOnType.DATABASE_MANAGER) as IDatabaseManager

        eventManager.subscribe(callback = { event: Event -> Unit
            if (event.type.equals(PhotoDatabaseEventType.SAVE_PHOTOS)) {
                e = event
            }
        })

        databaseManager.getPhotoDatabase().savePhotos(UnitDummyUtils.createDummyPhotos())

        delay(DELAY_AVERAGE)
        asserter.assertTrue("savePhotos", e != null && e!!.data != null && e!!.error == null)
    }

    @Test
    /**
     * Clean photos.
     */
    fun cleanPhotos() = runBlocking {
        var e: Event? = null

        val eventManager: IEventManager = AddOnManager.getAddOn(AddOnType.EVENT_MANAGER) as IEventManager
        val databaseManager: IDatabaseManager = AddOnManager.getAddOn(AddOnType.DATABASE_MANAGER) as IDatabaseManager

        eventManager.subscribe(callback = { event: Event -> Unit
            if (event.type.equals(PhotoDatabaseEventType.CLEAN_PHOTOS)) {
                e = event
            } else if (event.type.equals(PhotoDatabaseEventType.SAVE_PHOTOS)) {
                databaseManager.getPhotoDatabase().cleanPhotos()
            }
        })

        databaseManager.getPhotoDatabase().savePhotos(UnitDummyUtils.createDummyPhotos())

        delay(DELAY_AVERAGE)
        asserter.assertTrue("cleanPhotos", e != null && e!!.data == null && e!!.error == null)
    }
}