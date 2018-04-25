package jp.co.base.util

import io.reactivex.Scheduler

/**
 * Created by kit on 4/25/18.
 */
interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
}