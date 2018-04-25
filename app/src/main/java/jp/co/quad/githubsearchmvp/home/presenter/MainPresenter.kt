package jp.co.quad.githubsearchmvp.home.presenter

import io.reactivex.disposables.CompositeDisposable
import jp.co.base.mvp.BasePresenter
import jp.co.base.util.SchedulerProvider
import jp.co.quad.githubsearchmvp.api.Endpoints
import javax.inject.Inject

class MainPresenter @Inject constructor(var api: Endpoints, disposable: CompositeDisposable, scheduler: SchedulerProvider) : BasePresenter<MainView>(disposable, scheduler) {

    fun getRepos(searchKey: String) {
        view?.showProgress()
        disposable.add(api.search(searchKey)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(
                        { result ->
                            view?.hideProgress()
                            view?.onSearchResponse(result?.items)

                            if (result.items == null || result.items.isEmpty()) {
                                view?.noResult()
                            }
                        },
                        { _ ->
                            view?.hideProgress()
                            view?.onError()
                        })
        )
    }
}