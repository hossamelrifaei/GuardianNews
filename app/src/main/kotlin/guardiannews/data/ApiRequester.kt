package guardiannews.data

import guardiannews.model.FeedResponse
import io.reactivex.Single
import network.ApiService
import javax.inject.Inject

class ApiRequester @Inject internal constructor(private val apiService: ApiService) {
    fun getFeed(page: Int): Single<FeedResponse> {
        return apiService.getFeedForPage(page)
    }
}
