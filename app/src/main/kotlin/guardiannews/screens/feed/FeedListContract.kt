package guardiannews.screens.feed

import guardiannews.base.BaseContract
import guardiannews.model.Favourite
import guardiannews.model.Result

/**
 * Created by hossam
 */
interface FeedListContract : BaseContract {
    interface Presenter : BaseContract.Presenter<FeedListContract.View> {
        fun load()
    }

    interface View : BaseContract.View {
        fun addFeed(feedList: List<Result>)
        fun showFavorites(favourites: List<Favourite>)
    }
}