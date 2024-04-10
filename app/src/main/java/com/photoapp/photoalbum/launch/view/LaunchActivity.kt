package com.Rishabh Prajapati.photoalbum.launch.view

import android.os.Bundle
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.view.BaseView
import com.Rishabh Prajapati.photoalbum.view.IViewManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.feature.albumlist.view.AlbumListActivity




class LaunchActivity : BaseView() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }

    override fun onStart() {
        super.onStart()

        // Entry activity.
        val activityManager: IViewManager = getAddOn(AddOnType.VIEW_MANAGER) as IViewManager
        activityManager.loadView(AlbumListActivity::class.java)

        // Finish.
        finish()
    }
}
