package com.Rishabh Prajapati.photoalbum.event

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import com.Rishabh Prajapati.photoalbum.utils.CoroutineUtils
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.coroutines.CoroutineContext

interface IEventManager : IAddOn {
    /**
     * Send event.
     * @param event sent event
     * @param context use context
     */
    fun send(event: Event, context: CoroutineContext = CoroutineUtils.DISPATCHER_MAIN)

    /**
     * Subscribe to receiving mChannel.
     * @return receiving mChannel
     */
    fun subscribe() : ReceiveChannel<Event>

    /**
     * Subscribe to receiving mChannel.
     * @param callback event callback
     * @param context use context
     * @return receiving mChannel
     */
    fun subscribe(callback: (event: Event) -> Unit, context: CoroutineContext = CoroutineUtils.DISPATCHER_MAIN) : ReceiveChannel<Event>

    /**
     * Unsubscribe from receiving mChannel.
     * @param receiveChannel receiving mChannel
     */
    fun unsubscribe(receiveChannel: ReceiveChannel<Event>?)
}