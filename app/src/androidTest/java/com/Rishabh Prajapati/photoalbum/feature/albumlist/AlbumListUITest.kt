package com.Rishabh Prajapati.photoalbum.feature.albumlist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.core.BaseUITest
import com.Rishabh Prajapati.photoalbum.core.IAfterWait
import com.Rishabh Prajapati.photoalbum.core.IBeforeWait
import com.Rishabh Prajapati.photoalbum.event.Event
import com.Rishabh Prajapati.photoalbum.feature.albumlist.event.AlbumListEventType
import com.Rishabh Prajapati.photoalbum.feature.albumlist.view.AlbumListActivity
import com.Rishabh Prajapati.photoalbum.utils.RecyclerViewAssertion.withItemCount
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumListUITest : BaseUITest() {

    @Rule @JvmField
    var mActivityTestRule: ActivityTestRule<AlbumListActivity> = ActivityTestRule(
        AlbumListActivity::class.java, true, false)

    @Test
    /**
     * Load albums.
     */
    fun loadAlbums() {
        wait(AlbumListEventType.VIEWMODEL_RESPONSE_LOAD_ALBUMS, object : IBeforeWait {
            override fun beforeWait() {
                val intent = Intent(getContext(), AlbumListActivity::class.java)
                mActivityTestRule.launchActivity(intent)
            }

        }, object : IAfterWait {
            override fun afterWait(events: List<Event>) {

                onView(withId(R.id.albumlist_ryv_items)).check(withItemCount(greaterThan(0)))
                onView(withId(R.id.albumlist_txv_message)).check(matches(not(isDisplayed())))
                onView(withId(R.id.albumlist_btn_retry)).check(matches(not(isDisplayed())))
            }
        })
    }
}