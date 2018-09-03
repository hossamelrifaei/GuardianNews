package guardiannews.screens.feed

import base.BaseFragment
import guardiannews.model.Favourite
import guardiannews.model.Result
import kotlinx.android.synthetic.main.fragment_feed.*
import theguardian.com.guardiannews.R
import javax.inject.Inject

/**
 * Created by hossam
 */
class FeedFragment : BaseFragment(), FeedListContract.View {
    companion object {
        @JvmStatic
        fun newInstance(): FeedFragment {
            return FeedFragment()
        }
    }

    private val feedAdapter = FeedAdapter()
    private val favAdapter = FavouriteAdapter()
    @Inject
    lateinit var presenter: FeedListPresenterImpl


    override fun showFavorites(favourites: List<Favourite>) {
        favAdapter.addFav(favourites.toMutableList())
    }

    override fun attach() {
        feed_list.adapter = feedAdapter
        feedAdapter.listener = presenter
        fav_list.adapter = favAdapter
        favAdapter.listener = presenter
        presenter.attachView(this)

    }

    override fun addFeed(feedList: List<Result>) {
        (feed_list.adapter as FeedAdapter).addFeed(feedList.toMutableList())
    }


    override fun detach() {
        presenter.detach()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_feed
    }
}