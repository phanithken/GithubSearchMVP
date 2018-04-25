package jp.co.base.mvp

/**
 * Created by kit on 4/25/18.
 */
interface BaseView {
    fun onError()
    fun setPresenter(presenter: BasePresenter<*>)
}