package di

import android.arch.persistence.room.Room
import android.content.Context
import base.GuardianApp
import dagger.Module
import dagger.Provides
import guardiannews.database.AppDatabase
import guardiannews.ui.RxBus
import javax.inject.Singleton


/**
 * Created by hossam
 */
@Module
class AppModule(private val app: GuardianApp) {
    @Provides
    fun provideApplication(app: GuardianApp): Context = app

    @Provides
    @Singleton
    fun provideDataBase(): AppDatabase = Room.databaseBuilder(app,
            AppDatabase::class.java, "guardian_database").build()

    @Provides
    @Singleton
    fun provideRxBus(): RxBus = RxBus()
}