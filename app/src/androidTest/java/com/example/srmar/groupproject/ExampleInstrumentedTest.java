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
import static com.example.srmar.groupproject.R.id.hrHigh;
import static com.example.srmar.groupproject.R.id.hrLow;
import static com.example.srmar.groupproject.R.id.stepHigh;
import static com.example.srmar.groupproject.R.id.stepLow;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //integers for heart rate and step values for test
    private int a, b, c, d, t1Low, t1High, t2Low, t2High, t3Low, t3High;


    @Rule
    public ActivityTestRule<AthleteRangeActivity> mActivityRule = new ActivityTestRule<>(
            AthleteRangeActivity.class);

    @Before
    public void setValues(){
        a = 10000;
        b = 20000;
        c = 70;
        d = 100;
        t1Low = 0;
        t1High = 0;
        t2Low = 30;
        t2High = 20;
        t3Low = 20;
        t3High = 50;
    }

    @Test
    //enters high and low values for step range, on click these values are assigned to variables
    //the variables and values are checked to make sure they are equal.
    public void stepTest(){
        onView(withId(stepLow)).perform(typeText(String.valueOf(a)));
        onView(withId(stepHigh)).perform(typeText(String.valueOf(b)));
        onView(withId(R.id.stepEnter)).perform(click());
        onView(withId(R.id.stepLow)).check(matches(withText(Integer.toString(mActivityRule.getActivity().getStepLow()))));
        onView(withId(R.id.stepHigh)).check(matches(withText(Integer.toString(mActivityRule.getActivity().getStepHigh()))));
    }

    @Test
    //enters high and low values for heart rate range, on click these values are assigned to variables
    //the variables and values are checked to make sure they are equal.
    public void hrTest(){
        onView(withId(hrLow)).perform(typeText(String.valueOf(c)));
        onView(withId(hrHigh)).perform(typeText(String.valueOf(d)));
        onView(withId(R.id.hrEnter)).perform(click());
        onView(withId(R.id.hrLow)).check(matches(withText(Integer.toString(mActivityRule.getActivity().getHrLow()))));
        onView(withId(R.id.hrHigh)).check(matches(withText(Integer.toString(mActivityRule.getActivity().getHrHigh()))));
    }

    @Test
    //The Following tests endure the correct text is displayed when a certain range is entered
    public void rangeTest1(){
        onView(withId(hrLow)).perform(typeText(String.valueOf(t1Low)));
        onView(withId(hrHigh)).perform(typeText(String.valueOf(t1High)));
        onView(withId(R.id.hrEnter)).perform(click());
        onView(withId(R.id.hrSetRange)).check(matches(withText("Heart Rate: No range set.")));
    }
    @Test
    public void rangeTest2(){
        onView(withId(hrLow)).perform(typeText(String.valueOf(t2Low)));
        onView(withId(hrHigh)).perform(typeText(String.valueOf(t2High)));
        onView(withId(R.id.hrEnter)).perform(click());
        onView(withId(R.id.hrSetRange)).check(matches(withText("Heart Rate: Invalid range.")));
    }
    @Test
    public void rangeTest3(){
        onView(withId(hrLow)).perform(typeText(String.valueOf(t3Low)));
        onView(withId(hrHigh)).perform(typeText(String.valueOf(t3High)));
        onView(withId(R.id.hrEnter)).perform(click());
        onView(withId(R.id.hrSetRange)).check(matches(withText("Heart Rate: "+mActivityRule.getActivity().hrRangeLow+" to "+mActivityRule.getActivity().hrRangeHigh+".")));
    }
}
