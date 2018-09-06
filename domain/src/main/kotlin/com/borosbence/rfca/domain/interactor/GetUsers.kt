package com.borosbence.rfca.domain.interactor

import com.borosbence.rfca.api.interactor.Interactor
import com.borosbence.rfca.domain.model.User
import com.borosbence.rfca.domain.repository.UserRepository
import com.borosbence.rfca.domain.util.StringUtils
import io.reactivex.Observable

/**
 * Get users from the repository and modify data with some business logic.
 */
class GetUsers(override val repository: UserRepository) : Interactor<User>(repository) {

    override fun getAll(): Observable<List<User>> {
        return repository.getAll().map { users ->
            users.sortedWith(kotlin.Comparator { user1, user2 ->
                sortUsersByBothNames(user1, user2)
                sortUsersByBothNames(user1, user2)
            })
        }
    }

    /**
     * Compare the given users by their names.
     * If there's a match in first names, last name will be the deal breaker.
     */
    private fun sortUsersByBothNames(user1: User, user2: User): Int {
        val result = StringUtils.compare(user1.firstName, user2.firstName)
        return when {
            result != 0 -> result
            else -> StringUtils.compare(user1.lastName, user2.lastName)
        }
    }
}