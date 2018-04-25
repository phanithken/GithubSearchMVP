package jp.co.base.di.component

import dagger.Component
import jp.co.base.di.module.AppModule
import javax.inject.Singleton

/**
 * Created by kit on 4/25/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
}