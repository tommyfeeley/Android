package com.Rishabh Prajapati.photoalbum.network.service.photo

import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.core.BaseUnitTest
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.event.IEventManager
import com.Rishabh Prajapati.photoalbum.network.service.IServiceManager
import com.Rishabh Prajapati.photoalbum.network.service.photo.event.PhotoServiceEventType
import com.Rishabh Prajapati.photoalbum.utils.UnitTestUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.asserter

class PhotoServiceUnitTest : BaseUnitTest() {

    @Test
    /**
     * Get photos online.
     */
    fun getPhotos_Online() = runBlocking {
        var e: Event? = null

        val eventManager: IEventManager = AddOnManager.getAddOn(AddOnType.EVENT_MANAGER) as IEventManager
        val serviceManager: IServiceManager = AddOnManager.getAddOn(AddOnType.SERVICE_MANAGER) as IServiceManager

        eventManager.subscribe(callback = { event: Event -> Unit
            if (event.type.equals(PhotoServiceEventType.GET_PHOTOS)) {
                e = event
            }
        })

        serviceManager.getPhotoService().getPhotos()

        delay(DELAY_AVERAGE)
        asserter.assertTrue("getPhotos_Online", e != null && e!!.data != null && e!!.error == null)
    }

    @Test
    /**
     * Get photos offline.
     */
    fun getPhotos_Offline() = runBlocking {
        // Enable offline.
        UnitTestUtils.offline()

        var e: Event? = null

        val eventManager: IEventManager = AddOnManager.getAddOn(AddOnType.EVENT_MANAGER) as IEventManager
        val serviceManager: IServiceManager = AddOnManager.getAddOn(AddOnType.SERVICE_MANAGER) as IServiceManager

        eventManager.subscribe(callback = { event: Event -> Unit
            if (event.type.equals(PhotoServiceEventType.GET_PHOTOS)) {
                e = event
            }
        })

        serviceManager.getPhotoService().getPhotos()

        delay(DELAY_AVERAGE)
        asserter.assertTrue("getPhotos_Offline", e != null && e!!.data == null && e!!.error != null)
    }
}