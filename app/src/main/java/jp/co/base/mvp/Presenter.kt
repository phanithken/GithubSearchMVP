package jp.co.base.mvp

import android.view.View

/**
 * Created by kit on 4/25/18.
 */
interface Presenter<V: BaseView> {
    fun attachView(view: V)

    fun detachView()
}