package com.Rishabh Prajapati.photoalbum.utils

import android.content.Context
import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.context.IContextManager
import com.Rishabh Prajapati.photoalbum.database.photo.PhotoDB
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

object DatabaseUtils {
    // Photo database driver.
    val PHOTO_DB_DRIVER: SqlDriver by lazy {
        val contextManager: IContextManager? = AddOnManager.getAddOn(AddOnType.CONTEXT_MANAGER) as IContextManager?
        val context: Context? = contextManager?.getContext()
        AndroidSqliteDriver(PhotoDB.Schema, context!!, "Photo.db")
    }
}