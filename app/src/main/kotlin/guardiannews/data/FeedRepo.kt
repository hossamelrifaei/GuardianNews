package guardiannews.data

import di.ActivityScope
import guardiannews.model.FeedResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by hossam
 */

@ActivityScope
class FeedRepo @Inject internal constructor(private val apiRequesterProvider: Provider<ApiRequester>) {
    fun getFeed(page: Int): Single<FeedResponse> {
        return apiRequesterProvider.get().getFeed(page).subscribeOn(Schedulers.io())
    }
}