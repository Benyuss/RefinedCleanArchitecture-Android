package com.borosbence.rfca.api.interactor

import com.borosbence.rfca.api.repository.Repository
import io.reactivex.Observable

/**
 * Interactors or use cases holds the business logic.
 *
 * Only Presenters should access this.
 * It will get the data from the passed repository.
 */
abstract class Interactor<T>(open val repository: Repository<T>) {

    open fun getAll(): Observable<List<T>> {
        return repository.getAll()
    }
}