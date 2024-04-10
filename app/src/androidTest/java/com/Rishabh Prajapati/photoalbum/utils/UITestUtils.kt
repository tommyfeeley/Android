package com.Rishabh Prajapati.photoalbum.utils

import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.database.IDatabaseManager
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import kotlinx.coroutines.runBlocking


object UITestUtils {

    fun online() {
        mockkObject(ConnectivityUtils)
        every { ConnectivityUtils.isOnline() } returns true

        val databaseManager: IDatabaseManager = AddOnManager.getAddOn(AddOnType.DATABASE_MANAGER) as IDatabaseManager
        databaseManager.getPhotoDatabase().cleanPhotos()
    }

    fun offline() = runBlocking {
        mockkStatic(ConnectivityUtils::class)
        every { ConnectivityUtils.isOnline() } returns false

        val databaseManager: IDatabaseManager = AddOnManager.getAddOn(AddOnType.DATABASE_MANAGER) as IDatabaseManager
        databaseManager.getPhotoDatabase().cleanPhotos()
    }
}