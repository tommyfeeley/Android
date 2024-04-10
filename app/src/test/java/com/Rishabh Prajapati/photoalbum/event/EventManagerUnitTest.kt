package com.Rishabh Prajapati.photoalbum.event

import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.core.BaseUnitTest
import com.Rishabh Prajapati.photoalbum.network.model.Error
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.asserter

class EventManagerUnitTest : BaseUnitTest() {

    private val DUMMY_EVENT_TYPE: String = "DUMMY_EVENT_TYPE"
    private val DUMMY_EVENT_DATA: String = "DUMMY_EVENT_DATA"
    private val DUMMY_EVENT_ERROR: Error = Error(0, "")

    @Test
    /**
     * Exchange events.
     */
    fun exchangeEvents() = runBlocking {
        var e: Event? = null

        val eventManager: IEventManager = AddOnManager.getAddOn(AddOnType.EVENT_MANAGER) as IEventManager
        eventManager.subscribe(callback = { event: Event -> Unit
            e = event
        })

        eventManager.send(createDummyEvent())

        delay(DELAY_MINIMUM)
        asserter.assertTrue("exchangeEvents", e != null && e!!.data != null && e!!.error != null)
    }

    private fun createDummyEvent() : Event {
        return Event(DUMMY_EVENT_TYPE, DUMMY_EVENT_DATA, DUMMY_EVENT_ERROR)
    }
}