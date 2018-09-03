package network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import guardiannews.model.FeedResponse
import guardiannews.network.DefaultOnDataMismatchAdapter
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by hossam
 */
@Module(includes = [(NetworkModule::class)])
object ServiceModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
            .add(DefaultOnDataMismatchAdapter.newFactory(FeedResponse::class.java, null))
            .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, callFactory: Call.Factory, @Named("base_url") baseUrl: String): Retrofit = Retrofit.Builder()
            .callFactory(callFactory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
}