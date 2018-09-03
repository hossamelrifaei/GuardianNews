package ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import di.ActivityScope
import guardiannews.screens.detail.DetailFragment
import theguardian.com.guardiannews.R
import javax.inject.Inject


/**
 * Created by hossam
 */
@ActivityScope
class RouterImpl @Inject internal constructor() : Router {
    private lateinit var fragmentManager: FragmentManager

    fun onCreate(activity: AppCompatActivity, initialScreen: Fragment) {
        init(activity.supportFragmentManager, initialScreen)
    }

    private fun init(fragmentManager: FragmentManager, rootScreen: Fragment) {
        this.fragmentManager = fragmentManager
        this.fragmentManager
        if (fragmentManager.fragments.size == 0) {
            fragmentManager.beginTransaction()
                    .replace(R.id.screen_container, rootScreen)
                    .commit()
        }
    }

    override fun pop(): Boolean {
        return fragmentManager != null && fragmentManager.popBackStackImmediate()
    }


    override fun goToDetail(bodyText: String, webTitle: String, item_img: ImageView) {
        fragmentManager
                .beginTransaction()
                .addSharedElement(item_img, ViewCompat.getTransitionName(item_img))
                .setTransition(TRANSIT_FRAGMENT_FADE)
                .replace(R.id.screen_container, DetailFragment.newInstance(ViewCompat.getTransitionName(item_img), webTitle, bodyText))
                .addToBackStack(null)
                .commit()
    }

}