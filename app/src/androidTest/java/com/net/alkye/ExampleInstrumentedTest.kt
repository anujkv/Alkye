package com.net.alkye

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.net.alkye.ui.screens.ArticleDetailScreen

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.net.alkye", appContext.packageName)
    }

    /*@Test
    fun testNavigationFromArticleDetailScreen() {
        val navController = TestNavHostController(context)
        composeTestRule.setContent {
            ArticleDetailScreen(articleId = 1, navController = navController)
        }

        composeTestRule.onNodeWithContentDescription("Logo Icon").performClick()
        // Verify navigation
        assertEquals(navController.currentDestination?.route, "expected_route")
    }*/
}

