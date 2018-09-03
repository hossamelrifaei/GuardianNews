package guardiannews.screens.detail

import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import di.FragmentScope
import javax.inject.Named

/**
 * Created by hossam
 */
@FragmentScope
@Subcomponent()
interface DetailFragmentSubcomponent : AndroidInjector<DetailFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailFragment>() {

        @BindsInstance
        abstract fun bindTitle(@Named("title") title: String?)

        @BindsInstance
        abstract fun bindBody(@Named("body") body: String?)

        @BindsInstance
        abstract fun bindImage(@Named("image") image: String?)

        override fun seedInstance(instance: DetailFragment) {
            bindTitle(instance.arguments?.getString(DetailFragment.EXTRA_FEED_TITLE))
            bindBody(instance.arguments?.getString(DetailFragment.EXTRA_FEED_BODY))
            bindImage(instance.arguments?.getString(DetailFragment.EXTRA_FEED_IMAGE))
        }
    }
}