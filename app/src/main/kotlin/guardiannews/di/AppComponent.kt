package di

import base.GuardianApp
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import guardiannews.data.FeedServiceModule
import network.ServiceModule
import javax.inject.Singleton

/**
 * Created by hossam
 */

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class)
    , (AppModule::class)
    , (ActivityBindingModule::class)
    , (ServiceModule::class)
    , FeedServiceModule::class])
interface AppComponent {
    fun inject(app: GuardianApp)
}