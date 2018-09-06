package com.borosbence.rfca.domain.repository

import com.borosbence.rfca.api.repository.Repository
import com.borosbence.rfca.domain.model.User

/**
 * Repository to get [User] data.
 *
 * If you want to have any specific CRUD methods, you should define these here.
 */
interface UserRepository : Repository<User>