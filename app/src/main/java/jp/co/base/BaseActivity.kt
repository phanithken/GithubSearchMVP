package jp.co.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import jp.co.base.di.component.AppComponent
import jp.co.base.event.DefaultEvent
import jp.co.base.mvp.BasePresenter
import jp.co.base.mvp.BaseView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.jetbrains.anko.toast

/**
 * Created by kit on 4/25/18.
 */
abstract class BaseActivity: AppCompatActivity(), BaseView {

    private var presenter: BasePresenter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        onActivityInject()
    }

    protected abstract fun onActivityInject()

    fun getAppComponent(): AppComponent = App.appComponent

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        presenter = null
    }

    override fun onError() {
        toast("Something went wrong")
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }

    @Subscribe
    fun defaultSubscriber(event: DefaultEvent) {}
}