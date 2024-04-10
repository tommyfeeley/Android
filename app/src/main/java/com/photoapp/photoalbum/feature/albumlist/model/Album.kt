package com.Rishabh Prajapati.photoalbum.feature.albumlist.model

import android.os.Parcelable
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo
import com.squareup.moshi.Json
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album (
    @field:Json(name = "id") val id: String,
    @field:Json(name = "photos") val photos: MutableList<Photo>
) : Parcelable {

    @IgnoredOnParcel
    val thumbnailUrl: String? by lazy {
        photos.first().thumbnailUrl
    }
}