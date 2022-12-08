package com.hadi.maydapp.presentation.views.home

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hadi.maydapp.R
import com.hadi.maydapp.presentation.views.Home.HomeActivity
import kotlinx.android.synthetic.main.activity_short_link_intro.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(HomeActivity::class.java, false, false)


    @Test
    fun onAppLaunchedSuccessfully(){
        activityRule.launchActivity(null)
    }

    /**
     * Please note only one of the following test will pass at any given time since they both can't happen.
     * To test the last case, one should have no item in the local database
     *
     */

    @Test
    fun onHomeActivityLaunchedConfirmRecyclerViewIsDisplayed() {
        activityRule.launchActivity(null)
        if(activityRule.activity.EMPTY_STATE)
            Espresso.onView(withId(R.id.empty_links_page))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun onHomeActivityLaunchedWithErrorGIFIsDisplayed() {
        activityRule.launchActivity(null)
        if(!activityRule.activity.EMPTY_STATE)
            Espresso.onView(withId(R.id.recylerViewLinks))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}