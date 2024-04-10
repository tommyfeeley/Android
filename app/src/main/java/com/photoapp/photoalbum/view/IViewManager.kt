package com.Rishabh Prajapati.photoalbum.view

import android.os.Parcelable
import com.Rishabh Prajapati.photoalbum.addon.IAddOn


interface IViewManager : IAddOn {
    /**
     * Get current view.
     * @return current view
     */
    fun getCurrentView() : BaseView?

    /**
     * Track starting view.
     * @param view view
     */
    fun onStartView(view: BaseView)

    /**
     * Track stopping view.
     * @param view view
     */
    fun onStopView(view: BaseView)

    /**
     * Load view.
     * @param view view class
     */
    fun loadView(view: Class<out BaseView>)

    /**
     * Load view with flags.
     * @param view view class
     * @param flags flags
     */
    fun loadView(view: Class<out BaseView>, flags: Int?)

    /**
     * Load view with data.
     * @param view view class
     * @param data data
     */
    fun loadView(view: Class<out BaseView>, data: Parcelable?)

    /**
     * Load view with flags and data.
     * @param view view class
     * @param flags flags
     * @param data data
     */
    fun loadView(view: Class<out BaseView>, flags: Int?, data: Parcelable?)
}