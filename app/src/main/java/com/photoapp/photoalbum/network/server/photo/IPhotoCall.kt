package com.Rishabh Prajapati.photoalbum.network.server.photo

import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo
import retrofit2.Call
import retrofit2.http.GET

interface IPhotoCall {
    /**
     * Get photos.
     * @return list of photo
     */
    @GET("img/shared/technical-test.json")
    fun getPhotos() : Call<List<Photo>>
}