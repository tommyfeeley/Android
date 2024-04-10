package com.Rishabh Prajapati.photoalbum.event

import com.Rishabh Prajapati.photoalbum.network.model.Error

data class Event (val type: String, val data: Any? = null, val error: Error? = null)