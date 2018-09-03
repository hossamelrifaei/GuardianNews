package guardiannews.ui

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


/**
 * Created by hossam
 */
class RxBus @Inject constructor() {
    private val bus = PublishSubject.create<Boolean>()

    fun send(o: Boolean) {
        bus.onNext(o)
    }

    fun toObservable(): Observable<Boolean> {
        return bus
    }
}