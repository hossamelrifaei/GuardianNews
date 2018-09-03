package network

import guardiannews.model.FeedResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hossam
 */

interface ApiService {
    @GET("search")
    fun getFeedForPage(@Query("page") page: Int): Single<FeedResponse>
}