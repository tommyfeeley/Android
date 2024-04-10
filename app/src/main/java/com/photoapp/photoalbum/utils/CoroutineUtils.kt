package com.Rishabh Prajapati.photoalbum.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object CoroutineUtils {
    // Dispatchers.
    val DISPATCHER_MAIN: CoroutineDispatcher = Dispatchers.Main
    val DISPATCHER_IO: CoroutineDispatcher = Dispatchers.IO
}