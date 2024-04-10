package com.Rishabh Prajapati.photoalbum.database

import com.Rishabh Prajapati.photoalbum.addon.AddOn
import com.Rishabh Prajapati.photoalbum.database.photo.IPhotoDatabase
import com.Rishabh Prajapati.photoalbum.database.photo.PhotoDB
import com.Rishabh Prajapati.photoalbum.database.photo.PhotoDatabase
import com.Rishabh Prajapati.photoalbum.utils.DatabaseUtils

class DatabaseManager : AddOn(), IDatabaseManager {
    private val mPhotoDatabase: IPhotoDatabase by lazy {
        val photoDatabase = PhotoDatabase(PhotoDB(DatabaseUtils.PHOTO_DB_DRIVER))
        photoDatabase.addAddOns(getAddOns())
        photoDatabase
    }

    /**
     * Get photo database.
     * @return photo database
     */
    override fun getPhotoDatabase(): IPhotoDatabase {
        return mPhotoDatabase
    }
}