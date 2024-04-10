package com.Rishabh Prajapati.photoalbum.network.queue

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import retrofit2.Call
import retrofit2.Response

interface IQueueManager : IAddOn {
    /**
     * Execute call and response via callback.
     * @param call execute call
     * @param callback callback for response
     */
    fun execute(call: Call<Any>, callback: (response: Response<Any>) -> Unit)
}