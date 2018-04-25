package jp.co.quad.githubsearchmvp.home.presenter

import jp.co.base.mvp.BaseView
import jp.co.quad.githubsearchmvp.home.model.RepoItem

interface MainView : BaseView{
    fun onSearchResponse(list: List<RepoItem>?)
    fun showProgress()
    fun hideProgress()
    fun noResult()
}