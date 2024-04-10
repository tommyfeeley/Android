package com.Rishabh Prajapati.photoalbum.network.queue

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class QueueManager : AddOn(), IQueueManager {

    companion object {
        private const val THREAD_POOL_SIZE: Int = 5
    }

    private val mExecutorService: ExecutorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE)

    /**
     * Execute call and response via callback.
     * @param call execute call
     * @param callback callback for response
     */
    override fun execute(call: Call<Any>, callback: (response: Response<Any>) -> Unit) {
        mExecutorService.execute(Runnable {
            val response: Response<Any> = call.execute()
            callback(response)
        })
    }

    /**
     * Clear addons.
     */
    override fun clearAddOns() {
        mExecutorService.shutdown()
        super.clearAddOns()
    }
}