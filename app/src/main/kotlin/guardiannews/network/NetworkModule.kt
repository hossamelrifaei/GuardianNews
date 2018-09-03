package network

import dagger.Module
import dagger.Provides
import guardiannews.network.ApiInterceptor
import okhttp3.Call
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by hossam
 */
@Module
object NetworkModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttp(): Call.Factory = OkHttpClient.Builder().addInterceptor(ApiInterceptor()).build()

    @JvmStatic
    @Provides
    @Named("base_url")
    fun provideBaseUrl(): String = "https://content.guardianapis.com/"

}