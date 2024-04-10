package com.Rishabh Prajapati.photoalbum.network.model.photo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo (
    @field:Json(name = "albumId") val albumId: String?,
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "thumbnailUrl") val thumbnailUrl: String?
) : Parcelable