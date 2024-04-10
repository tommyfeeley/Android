package com.Rishabh Prajapati.photoalbum.network.service

import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.core.BaseUnitTest
import com.Rishabh Prajapati.photoalbum.network.service.photo.IPhotoService
import org.junit.Test
import kotlin.test.asserter

class ServiceManagerUnitTest : BaseUnitTest() {

    @Test
    /**
     * Access photo service.
     */
    fun accessPhotoService() {
        val serviceManager: IServiceManager = AddOnManager.getAddOn(AddOnType.SERVICE_MANAGER) as IServiceManager
        val photoService: IPhotoService? = serviceManager.getPhotoService()
        asserter.assertTrue("accessPhotoService", photoService != null)
    }
}