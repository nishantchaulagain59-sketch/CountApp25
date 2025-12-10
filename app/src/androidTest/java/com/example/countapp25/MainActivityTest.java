package com.example.countapp25;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testTypeText_displayedCorrectly() {
        onView(withId(R.id.editTextInput))
                .perform(typeText("Hello World"));
        closeSoftKeyboard();

        onView(withId(R.id.editTextInput))
                .check(matches(withText("Hello World")));
    }

    @Test
    public void testCharacterCount() {
        onView(withId(R.id.editTextInput))
                .perform(typeText("Hello"));
        closeSoftKeyboard();

        // select "Characters"
        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Characters")).perform(click());

        onView(withId(R.id.buttonCount)).perform(click());

        onView(withId(R.id.textViewResult))
                .check(matches(withText("5")));
    }

    @Test
    public void testWordCount() {
        onView(withId(R.id.editTextInput))
                .perform(typeText("Hello World"));
        closeSoftKeyboard();

        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Words")).perform(click());

        onView(withId(R.id.buttonCount)).perform(click());

        onView(withId(R.id.textViewResult))
                .check(matches(withText("2")));
    }

    @Test
    public void testSentenceCount() {
        onView(withId(R.id.editTextInput))
                .perform(typeText("Hello world. Hi!"));
        closeSoftKeyboard();

        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Sentences")).perform(click());

        onView(withId(R.id.buttonCount)).perform(click());

        onView(withId(R.id.textViewResult))
                .check(matches(withText("2")));
    }
}
