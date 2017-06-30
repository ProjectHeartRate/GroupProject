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
 * Teats for AthleteStepsActivity class
 * @author Scott Martell, Jenna McNeil
 */
@RunWith(AndroidJUnit4.class)
public class StepsTests {

    //test value
    private int a;

    @Rule
    public ActivityTestRule<AthleteStepsActivity> mActivityRule = new ActivityTestRule<>(
            AthleteStepsActivity.class);

    /**
     * Sets test value
     */
    @Before
    public void setValues(){
        a = 10000;
    }

    /**
     * Tests that the seps value is displayed correctly.
     */
    @Test
    public void stepsTest1(){
        onView(withId(R.id.stepsToday)).check(matches(withText("Steps: "+mActivityRule.getActivity().getSteps()+".")));

    }
}
