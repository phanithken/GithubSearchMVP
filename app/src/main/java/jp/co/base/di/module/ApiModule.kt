package jp.co.base.di.module

import dagger.Provides
import jp.co.quad.githubsearchmvp.api.Endpoints
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by kit on 4/25/18.
 */
class ApiModule {
    @Provides
    @Singleton
    fun providesEndpoints(retrofit: Retrofit): Endpoints = retrofit.create(Endpoints::class.java)
}