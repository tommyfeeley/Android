package com.Rishabh Prajapati.photoalbum.feature.photolist.event

object PhotoListEventType {
    // Tag.
    const val TAG: String = "PHOTOLIST_EVENT_TYPE_"

    // Album list event types.
    const val VIEW_UPDATE_LOADER: String = TAG + "VIEW_UPDATE_LOADER"
    const val VIEW_UPDATE_MESSAGE: String = TAG + "VIEW_UPDATE_MESSAGE"

    const val VIEWMODEL_REQUEST_LOAD_PHOTOS: String = TAG + "VIEWMODEL_REQUEST_LOAD_PHOTOS"
    const val VIEWMODEL_RESPONSE_LOAD_PHOTOS: String = TAG + "VIEWMODEL_RESPONSE_LOAD_PHOTOS"

    const val MODEL_REQUEST_LOAD_PHOTOS: String = TAG + "MODEL_REQUEST_LOAD_PHOTOS"
    const val MODEL_RESPONSE_LOAD_PHOTOS: String = TAG + "MODEL_RESPONSE_LOAD_PHOTOS"
}