package score.gsoc.opendf.activities;

import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import score.gsoc.opendf.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lilan on 4/6/16.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void viewsMustBeDisplayed() {

        Resources resources = InstrumentationRegistry.getTargetContext().getResources();

        String appName = resources.getString(R.string.app_name);
        onView(withText(appName)).check(matches(isDisplayed()));

        String userNameHint = resources.getString(R.string.username);
        onView(withHint(userNameHint)).check(matches(isDisplayed()));

        String passwordHint = resources.getString(R.string.password);
        onView(withHint(passwordHint)).check(matches(isDisplayed()));
    }
}
