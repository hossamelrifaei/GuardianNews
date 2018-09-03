package guardiannews.base

/**
 * Created by hossam
 */
interface BaseContract {
    interface Presenter<in T> {
        fun attachView(view: T)
        fun detach()
    }

    interface View {
    }
}