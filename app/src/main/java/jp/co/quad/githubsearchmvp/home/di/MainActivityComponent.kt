package jp.co.quad.githubsearchmvp.home.di

import dagger.Component
import jp.co.base.di.ActivityScope
import jp.co.base.di.component.AppComponent
import jp.co.quad.githubsearchmvp.home.MainActivity

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}