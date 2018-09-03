package guardiannews.screens.feed

import android.widget.ImageView
import di.FragmentScope
import guardiannews.data.FeedRepo
import guardiannews.database.AppDatabase
import guardiannews.ui.AdapterListener
import guardiannews.ui.RxBus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ui.DisposableManager
import ui.RouterImpl
import javax.inject.Inject

/**
 * Created by hossam
 */
const val FIRST_PAGE = 1

@FragmentScope
class FeedListPresenterImpl @Inject internal constructor(private val feedRepo: FeedRepo
                                                         , private val disposableManager: DisposableManager
                                                         , private val router: RouterImpl
                                                         , private val bus: RxBus
                                                         , private val dataBase: AppDatabase) : FeedListContract.Presenter, AdapterListener {

    private var page: Int
    private var view: FeedListContract.View? = null

    init {
        this.page = FIRST_PAGE
        load()
        loadFavorites()
        disposableManager.add(bus.toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { next ->
                    if (next) {
                        loadFavorites()
                    }
                })
    }

    private fun loadFavorites() {
        dataBase.favouriteDao().loadFavorite()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response -> view?.showFavorites(response) },
                        { _ -> })
    }

    override fun onItemClick(bodyText: String, webTitle: String, item_img: ImageView) {
        router.goToDetail(bodyText, webTitle, item_img)
    }

    override fun onLoadMore() {
        page++
        load()
    }


    override fun attachView(view: FeedListContract.View) {
        this.view = view
    }


    override fun detach() {
        disposableManager.dispose()
    }


    override fun load() {
        disposableManager.add(feedRepo.getFeed(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ feedResponse -> view?.addFeed(feedResponse.response.results) },
                        { _ -> }))
    }
}
