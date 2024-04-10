package com.Rishabh Prajapati.photoalbum.network.retrofit

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import retrofit2.Retrofit

interface IRetrofitManager : IAddOn {
    /**
     * Get retrofit.
     * @return retrofit
     */
    fun getRetrofit() : Retrofit
}