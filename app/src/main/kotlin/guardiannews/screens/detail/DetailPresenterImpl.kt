package guardiannews.screens.detail

import di.FragmentScope
import guardiannews.database.AppDatabase
import guardiannews.model.Favourite
import guardiannews.ui.RxBus
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hossam
 */
@FragmentScope
class DetailPresenterImpl @Inject internal constructor(@Named("title") private var title: String?
                                                       , @Named("body") private var body: String?
                                                       , @Named("image") private var image: String?
                                                       , private val database: AppDatabase
                                                       , private var bus: RxBus) : DetailContract.Presenter {
    override fun addToFavorite() {
        var favourite = Favourite()
        body?.let { favourite.body = it }
        title?.let { favourite.title = it }
        image?.let { favourite.image = it }
        Observable.fromCallable { database.favouriteDao().insertFavourite(favourite) }.subscribeOn(Schedulers.io())
                .subscribe({ _ -> bus.send(true) }
                        , { _ -> })
    }

    private lateinit var view: DetailContract.View
    override fun attachView(view: DetailContract.View) {
        this.view = view
        view.showData(title, body)
    }

    override fun detach() {
    }
}