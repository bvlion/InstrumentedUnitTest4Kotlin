package ambitious.net.instrumentedunittest4kotlin

import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityUITest {

    @Rule @JvmField
    public var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    /** 空でボタンを押下する */
    @Test
    @Throws(Exception::class)
    fun sampleTest() {
        // 入力エリアを空に
        onView(withId(R.id.text)).perform(replaceText("test"))

        // キーボード閉じる
        closeSoftKeyboard()

        // ボタン押す！
        onView(withId(R.id.check_button)).perform(click())

        // エラーのタイトルのダイアログ出てるよね？
        onView(withText(R.string.error_title)).inRoot(isDialog()).check(matches(isDisplayed()))

        // ダイアログはこうやって閉じる
        onView(withId(android.R.id.button1)).perform(click())
    }
}
