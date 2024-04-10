package com.Rishabh Prajapati.photoalbum.network.retrofit

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitManager : AddOn(), IRetrofitManager {

    private val BASE_URL: String = "https://static.leboncoin.fr/"
    private var mRetrofit: Retrofit

    init {
        val clientBuilder = OkHttpClient.Builder()
        mRetrofit = Retrofit.Builder()
            .client(clientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    /**
     * Get retrofit.
     * @return retrofit
     */
    override fun getRetrofit() : Retrofit {
        return mRetrofit
    }
}