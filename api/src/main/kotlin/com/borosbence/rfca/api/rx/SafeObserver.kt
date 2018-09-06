package com.borosbence.rfca.api.rx

import io.reactivex.observers.DisposableObserver

/**
 * This observer provides auto-dispose mechanism and you won't encounter any OnErrorNotImplementedException in your Rx streams if you subscribe with this type.
 * Much safer and cleaner then using lambdas only.
 */
abstract class SafeObserver<T> : DisposableObserver<T>() {

    override fun onComplete() {
        dispose()
    }

    override fun onNext(t: T) { /* Default implementation. Can be overridden. */
    }

    override fun onError(e: Throwable) {
        dispose()
    }
}