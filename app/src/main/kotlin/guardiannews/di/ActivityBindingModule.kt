package di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import guardiannews.MainActivity
import guardiannews.home.HomeModule

/**
 * Created by hossam
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun mainActivity(): MainActivity
}