package com.gunder.film.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gunder.film.utils.DataDummy
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.gunder.film.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    private val dummyMove = DataDummy.getDummyMovie()
    private val dummyTv = DataDummy.getdummyTv()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMove.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyMove[0].title)))
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyMove[0].description)))
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date_detail)).check(matches(withText(dummyMove[0].releaseYear)))
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyMove[0].genre)))
        onView(withId(R.id.iv_item_photo_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_cover_detail)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTv() {
        onView(withText("TV")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun loadDetailTv() {
        onView(withText("TV")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyTv[0].description)))
        onView(withId(R.id.tv_release_date_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date_detail)).check(matches(withText(dummyTv[0].releaseYear)))
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyTv[0].genre)))
        onView(withId(R.id.iv_item_photo_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_cover_detail)).check(matches(isDisplayed()))
    }
}