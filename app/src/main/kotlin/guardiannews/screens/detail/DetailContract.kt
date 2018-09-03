package guardiannews.screens.detail

import guardiannews.base.BaseContract

/**
 * Created by hossam
 */
interface DetailContract : BaseContract {
    interface Presenter : BaseContract.Presenter<DetailContract.View> {
        fun addToFavorite()
    }

    interface View : BaseContract.View {
        fun showData(title: String?, body: String?)
    }
}