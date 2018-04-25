package jp.co.base.mvp

import android.view.View
import io.reactivex.disposables.CompositeDisposable
import jp.co.base.util.SchedulerProvider
import java.lang.ref.WeakReference

/**
 * Created by kit on 4/25/18.
 */
class BasePresenter<V: BaseView> constructor(var disposable: CompositeDisposable, var scheduler: SchedulerProvider) : Presenter<V> {

    private var weakReference: WeakReference<V>? = null

    override fun attachView(view: V) {
        if (!isViewAttached){
            weakReference = WeakReference(view)
            view.setPresenter(this)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
        disposable.clear()
    }

    val view: V? get() = weakReference?.get()

    private val isViewAttached: Boolean get() = weakReference != null && weakReference!!.get() != null
}