package jp.co.base.di.component

import android.app.Application
import com.google.gson.Gson
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import jp.co.base.di.module.ApiModule
import jp.co.base.di.module.AppModule
import jp.co.base.di.module.OkHttpModule
import jp.co.base.helper.SpHelper
import jp.co.base.util.AppSchedulerProvider
import jp.co.quad.githubsearchmvp.api.Endpoints
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.annotation.Resource
import javax.annotation.Resources
import javax.inject.Singleton

/**
 * Created by kit on 4/25/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, Retrofit::class, ApiModule::class, OkHttpModule::class))
interface AppComponent {
    fun application(): Application
    fun gson(): Gson
    fun resources(): Resources
    fun retrofit(): Retrofit
    fun endpoints(): Endpoints
    fun cache(): Cache
    fun client(): OkHttpClient
    fun loggingInterceptor(): HttpLoggingInterceptor
    fun spHelper(): SpHelper
    fun compositeDisposable(): CompositeDisposable
    fun schedulerProvider(): AppSchedulerProvider
}