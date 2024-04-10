package com.Rishabh Prajapati.photoalbum.database

import com.Rishabh Prajapati.photoalbum.addon.IAddOn
import com.Rishabh Prajapati.photoalbum.database.photo.IPhotoDatabase

interface IDatabaseManager : IAddOn {
    /**
     * Get photo database.
     * @return photo database
     */
    fun getPhotoDatabase() : IPhotoDatabase
}