package guardiannews

import android.support.v4.app.Fragment
import base.BaseActivity
import guardiannews.screens.feed.FeedFragment
import theguardian.com.guardiannews.R

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialScreen(): Fragment {
        return FeedFragment.newInstance()
    }
}
