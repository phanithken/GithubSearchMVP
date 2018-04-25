package jp.co.quad.githubsearchmvp.home.di

import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import jp.co.base.di.ActivityScope
import jp.co.base.util.AppSchedulerProvider
import jp.co.quad.githubsearchmvp.api.Endpoints
import jp.co.quad.githubsearchmvp.home.presenter.MainPresenter

class MainActivityModule {
    @Provides
    @ActivityScope
    internal fun providesHomePresenter(api: Endpoints, disposable: CompositeDisposable, scheduler: AppSchedulerProvider): MainPresenter =
            MainPresenter(api, disposable, scheduler)
}