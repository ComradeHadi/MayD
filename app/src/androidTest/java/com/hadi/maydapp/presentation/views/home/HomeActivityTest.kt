package com.hadi.maydapp.presentation.views.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hadi.maydapp.R
import com.hadi.maydapp.presentation.views.Home.HomeActivity
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

    @Test
    fun onHomeActivityLaunchedConfirmRecyclerViewIsDisplayed() {
        activityRule.launchActivity(null)
        onView(withId(R.id.teams_recycler_view_list))
            .check(matches(isDisplayed()))
    }

}
