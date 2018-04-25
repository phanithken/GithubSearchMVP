package jp.co.quad.githubsearchmvp.home


import android.os.Bundle
import jp.co.base.BaseActivity
import jp.co.base.helper.SpHelper
import jp.co.quad.githubsearchmvp.R
import jp.co.quad.githubsearchmvp.home.di.MainActivityModule
import jp.co.quad.githubsearchmvp.home.model.RepoItem
import jp.co.quad.githubsearchmvp.home.presenter.MainPresenter
import jp.co.quad.githubsearchmvp.home.presenter.MainView
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var spHelper: SpHelper

    override fun onActivityInject() {
        DaggerHomeActivityComponent.builder().appComponent(getAppComponent())
                .homeActivityModule(MainActivityModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun onSearchResponse(list: List<RepoItem>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun noResult() {
        toast("We couldn't find any repository.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
    }

    private fun initAdapter(){
        // initialize adapter for recycler view
    }
}
