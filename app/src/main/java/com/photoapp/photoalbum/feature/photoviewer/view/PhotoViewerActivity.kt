package com.Rishabh Prajapati.photoalbum.feature.photoviewer.view

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.view.BaseView
import com.Rishabh Prajapati.photoalbum.network.model.photo.Photo
import com.Rishabh Prajapati.photoalbum.picture.IPictureManager
import com.Rishabh Prajapati.photoalbum.picture.PictureCallback
import com.Rishabh Prajapati.photoalbum.utils.ConnectivityUtils
import kotlinx.android.synthetic.main.activity_photoviewer.*

class PhotoViewerActivity : BaseView(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var mPictureManager: IPictureManager
    private lateinit var mPhoto: Photo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Fullscreen.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_photoviewer)

        mPictureManager = AddOnManager.getAddOn(AddOnType.PICTURE_MANAGER) as IPictureManager
        mPhoto = getData() as Photo

        photoviewer_srl_photo.setOnRefreshListener(this)
        photoviewer_txv_title.text = getString(R.string.photoviewer_photo_title, mPhoto.id)
        photoviewer_txv_description.text = mPhoto.title
        photoviewer_phv_photo.setImageDrawable(null)

        photoviewer_btn_retry.setOnClickListener(View.OnClickListener {
            onClickRetry()
        })

        // Load photo.
        loadPhoto()
    }

    /**
     * Update loader.
     * @param show flag
     */
    private fun updateLoader(show: Boolean) {
        if (show) {
            photoviewer_pgb_loader.visibility = View.VISIBLE
            photoviewer_phv_photo.visibility = View.GONE
            updateMessage(null)
        } else {
            photoviewer_pgb_loader.visibility = View.GONE
        }
    }

    /**
     * Update message.
     * @param message message
     */
    private fun updateMessage(message: String?) {
        if (message != null) {
            photoviewer_txv_message.text = message
            photoviewer_txv_message.visibility = View.VISIBLE
            photoviewer_btn_retry.visibility = View.VISIBLE
            photoviewer_phv_photo.visibility = View.GONE
            updateLoader(false)
        } else {
            photoviewer_txv_message.visibility = View.GONE
            photoviewer_btn_retry.visibility = View.GONE
        }
    }

    /**
     * On click retry, reload photo.
     */
    private fun onClickRetry() {
        loadPhoto()
    }

    /**
     * On refresh, reload photo.
     */
    override fun onRefresh() {
        photoviewer_srl_photo.isRefreshing = false
        loadPhoto()
    }

    private fun loadPhoto() {
        // Show loader.
        updateLoader(true)

        mPictureManager.load(mPhoto.url!!, photoviewer_phv_photo, object: PictureCallback {
            override fun onSuccess(url: String, bitmap: Bitmap) {
                photoviewer_phv_photo.visibility = View.VISIBLE
                // Better viewer control.
                photoviewer_srl_photo.isEnabled = false
                updateLoader(false)
            }

            override fun onFailure(url: String, throwable: Throwable) {

                mPictureManager.load(mPhoto.thumbnailUrl!!, photoviewer_phv_photo, object: PictureCallback {
                    override fun onSuccess(url: String, bitmap: Bitmap) {
                        photoviewer_phv_photo.visibility = View.VISIBLE
                        // Better viewer control.
                        photoviewer_srl_photo.isEnabled = false
                        updateLoader(false)
                    }

                    override fun onFailure(url: String, throwable: Throwable) {
                        if (!ConnectivityUtils.isOnline()) {
                            updateMessage(getString(R.string.photoviewer_no_connectivity))

                        } else {
                            updateMessage(getString(R.string.photoviewer_error_load))
                        }
                    }

                })
            }
        })
    }
}
