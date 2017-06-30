package com.example.srmar.groupproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Tests for AthleteHeartRateActivity class.
 * @author Scott Martell, Jenna McNeil
 */
@RunWith(AndroidJUnit4.class)
public class HeartRateTests {

    //test value
    private int a;

    @Rule
    public ActivityTestRule<AthleteHeartRateActivity> mActivityRule = new ActivityTestRule<>(
            AthleteHeartRateActivity.class);

    /**
     * Sets test value
     */
    @Before
    public void setValues(){
        a = 100;
    }

    /**
     * Tests that the heartrate is displayed correctly.
     */
    @Test
    public void hrTest1(){
        onView(withId(R.id.heartrateCurrent)).check(matches(withText("Heart Rate: "+mActivityRule.getActivity().getHeartRate()+".")));
    }
}
