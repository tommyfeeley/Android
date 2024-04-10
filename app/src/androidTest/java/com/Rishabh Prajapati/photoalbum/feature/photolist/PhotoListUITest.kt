package com.Rishabh Prajapati.photoalbum.feature.photolist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.view.BaseView
import com.Rishabh Prajapati.photoalbum.core.BaseUITest
import com.Rishabh Prajapati.photoalbum.core.IAfterWait
import com.Rishabh Prajapati.photoalbum.core.IBeforeWait
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.feature.photolist.event.PhotoListEventType
import com.Rishabh Prajapati.photoalbum.feature.photolist.view.PhotoListActivity
import com.Rishabh Prajapati.photoalbum.utils.RecyclerViewAssertion.withItemCount
import com.Rishabh Prajapati.photoalbum.utils.UIDummyUtils
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class PhotoListUITest : BaseUITest() {
    @Rule @JvmField
    var mActivityTestRule: ActivityTestRule<PhotoListActivity> = ActivityTestRule(
        PhotoListActivity::class.java, true, false)

    @Test
    /**
     * Load photos.
     */
    fun loadPhotos() {
        wait(PhotoListEventType.VIEWMODEL_RESPONSE_LOAD_PHOTOS, object : IBeforeWait {
            override fun beforeWait() {
                val intent = Intent(getContext(), PhotoListActivity::class.java)
                intent.putExtra(BaseView.KEY_DATA, UIDummyUtils.createDummyAlbum())
                mActivityTestRule.launchActivity(intent)
            }

        }, object : IAfterWait {
            override fun afterWait(events: List<Event>) {

                onView(withId(R.id.photolist_ryv_items)).check(withItemCount(greaterThan(0)))
                onView(withId(R.id.photolist_txv_message)).check(matches(not(isDisplayed())))
                onView(withId(R.id.photolist_btn_retry)).check(matches(not(isDisplayed())))
            }
        })
    }
}