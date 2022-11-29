
package com.openclassrooms.entrevoisins.neighbour_list;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Test class for list of neighbours
 */

@RunWith(AndroidJUnit4.class)

public class NeighboursListTest {

    /**
     * 12 neighbours
     */
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }


    /**
     *  Given when the complete list of neighbours
     *  When is displayed
     *  Then it should had at least 1 item in it
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     *  Given we remove the element at position 2
     *  When perform a click on a delete icon
     *  Then the number of element is 11
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT));
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT - 1));
    }

    /**
     * Given the first element of the neighbour list
     * When perform a click on it
     * Then their profile page is launched
     */
    @Test
    public void onClickOnListItem_shouldReturnDetailActivity() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.activity_neighbour_details)).check(matches(isDisplayed()));
    }

    /**
     * Given first element of the list matches with "Caroline"
     * When perform a click on it
     * Then profile page name should display "Caroline" name
     */
    @Test
    public void displayedNeighbourInfo_displayedNeighbourName_shouldMatch() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.neighbourProfilePicName)).check(matches(withText("Caroline")));
    }

    /**
     * Given we add Chloé to favorite
     * When we click on "Favorites" tab
     * Then the list of favorite displays Chloé
     */
    @Test
    public void onFavTabClick_getFavoriteNeighbours_favListIsDisplayed() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).perform(actionOnItemAtPosition(2, click()));
        onView(withId(R.id.addFavoriteFab)).perform(click());
        pressBack();
        onView(withContentDescription("Favorites")).perform(click());
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(matches(hasChildCount(1)));
        onView(allOf(withId(R.id.item_list_name), isDisplayed())).check(matches(withText("Chloé")));
    }
}