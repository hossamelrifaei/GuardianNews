package guardiannews.data

import dagger.Module
import dagger.Provides
import network.ApiService
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by hossam
 */
@Module
object FeedServiceModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create<ApiService>(ApiService::class.java)
}