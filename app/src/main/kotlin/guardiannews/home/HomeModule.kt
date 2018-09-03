package guardiannews.home

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import di.FragmentScope
import guardiannews.screens.detail.DetailFragment
import guardiannews.screens.detail.DetailFragmentSubcomponent
import guardiannews.screens.feed.FeedFragment


/**
 * Created by hossam
 */
@Module(subcomponents = [DetailFragmentSubcomponent::class])
abstract class HomeModule {
    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun provideFeedFragment(): FeedFragment


    @Binds
    @IntoMap
    @FragmentKey(DetailFragment::class)
    internal abstract fun bindDetailFragmentInjectorFactory(builder: DetailFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>

}