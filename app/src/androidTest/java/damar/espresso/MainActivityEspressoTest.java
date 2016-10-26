package damar.espresso;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void WriteText(){
        onView(withId(R.id.inputField)).perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.inputField)).check(matches(withText("HELLO")));
    }

    @Test
    public void CheckLabel(){
        onView(withId(R.id.changeText)).check(matches(withText("Change Text")));
        onView(withId(R.id.switchActivity)).check(matches(withText("Change Text2")));
    }

    @Test
    public void EnsureTextChangesWork() {
        onView(withId(R.id.inputField)).perform(typeText("Hi First"), closeSoftKeyboard());
        onView(withId(R.id.inputField)).check(matches(withText("Hi First")));
        onView(withId(R.id.changeText)).perform(click());
        onView(withId(R.id.inputField)).check(matches(withText("first")));
    }

    @Test
    public void EnsureTextChanges2Work() {
        onView(withId(R.id.inputField)).perform(typeText("Hi Second"), closeSoftKeyboard());
        onView(withId(R.id.inputField)).check(matches(withText("Hi Second")));
        onView(withId(R.id.switchActivity)).perform(click());
        onView(withId(R.id.inputField)).check(matches(withText("second")));
    }
}