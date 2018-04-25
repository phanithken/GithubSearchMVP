package jp.co.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import jp.co.base.di.component.AppComponent
import jp.co.base.mvp.BasePresenter
import jp.co.base.mvp.BaseView

/**
 * Created by kit on 4/25/18.
 */
abstract class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        onActivityInject()
    }

    protected abstract fun onActivityInject()

    fun getAppComponent(): AppComponent

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onError() {

    }

    override fun setPresenter(presenter: BasePresenter<*>) {

    }
}