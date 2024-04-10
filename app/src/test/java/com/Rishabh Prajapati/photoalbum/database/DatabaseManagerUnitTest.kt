package com.Rishabh Prajapati.photoalbum.database

import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.core.BaseUnitTest
import com.Rishabh Prajapati.photoalbum.database.photo.IPhotoDatabase
import org.junit.Test
import kotlin.test.asserter

class DatabaseManagerUnitTest : BaseUnitTest() {

    @Test
    /**
     * Access photo database.
     */
    fun accessPhotoDatabase() {
        val databaseManager: IDatabaseManager = AddOnManager.getAddOn(AddOnType.DATABASE_MANAGER) as IDatabaseManager
        val photoDatabase: IPhotoDatabase? = databaseManager.getPhotoDatabase()
        asserter.assertTrue("accessPhotoDatabase", photoDatabase != null)
    }
}