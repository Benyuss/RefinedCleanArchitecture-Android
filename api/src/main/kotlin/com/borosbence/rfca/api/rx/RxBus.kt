package com.borosbence.rfca.api.rx

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * RxBus is a broadcast manager (like event bus) which you can user across the whole project.
 *
 * It's Rx driven so the usual rules apply.
 */
object RxBus {

    private val publisher = PublishSubject.create<Any>()

    /**
     * Emit [event] of type [Any] which can be intercepted by [listen].
     */
    fun publish(event: Any) {
        publisher.onNext(event)
    }

    /**
     * Listen for any emission previously started by [publish] and act on it.
     * This callback receives the emitted object of type [eventType].
     */
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}