package com.example.android.codelabs.navigation

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FlowStepFragmentTest {
  @Test fun testStepFragmentDefaultArgs() {
    val directions = HomeFragmentDirections.nextAction()
    val scenario: FragmentScenario<FlowStepFragment> = launchFragmentInContainer(directions.arguments)

    scenario.onFragment { fragment ->
      val args = FlowStepFragmentArgs.fromBundle(fragment.arguments!!)
      assertThat("Incorrect flow step num", args.flowStepNumber == 1)
    }
  }


  @Test fun testStepFragmentArgs() {
    val directions = HomeFragmentDirections.nextAction(flowStepNumber = 2)
    val scenario: FragmentScenario<FlowStepFragment> = launchFragmentInContainer(directions.arguments)

    scenario.onFragment { fragment ->
      val args = FlowStepFragmentArgs.fromBundle(fragment.arguments!!)
      assertThat("Incorrect flow step num", args.flowStepNumber == 2)
    }
  }


  @Test fun testStepFragmentText() {
    val directions = HomeFragmentDirections.nextAction(flowStepNumber = 2)
    val scenario: FragmentScenario<FlowStepFragment> = launchFragmentInContainer(directions.arguments)
    onView(withText("Step Two")).check(matches(isDisplayed()))
  }

  @Test fun testStepFragmentRecreate() {

    val directions = HomeFragmentDirections.nextAction()
    val scenario: FragmentScenario<FlowStepFragment> = launchFragmentInContainer(directions.arguments)

    scenario.recreate()

    scenario.onFragment { fragment ->
      val args = FlowStepFragmentArgs.fromBundle(fragment.arguments!!)
      assert(args.flowStepNumber == 1)
    }
  }
}

