package jp.co.quad.githubsearchmvp.api

import io.reactivex.Observable
import jp.co.quad.githubsearchmvp.home.model.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {
    @GET("/search/repositories?sort=stars&orderdesc")
    fun search(@Query("q")key: String): Observable<RepoResponse>
}