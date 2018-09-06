package com.borosbence.rfca.presentation.users.presenter

import com.borosbence.rfca.presentation.core.Presenter
import com.borosbence.rfca.presentation.users.adapter.UserAdapter
import com.borosbence.rfca.presentation.users.vm.UserVMFactory
import com.borosbence.rfca.presentation.users.vm.UserViewModel
import com.borosbence.rfca.presentation.users.vm.UserViewState

/**
 * Presenter to control the [com.borosbence.rfca.presentation.users.view.UserView] display logic.
 */
interface UserPresenter : Presenter {

    var viewModel: UserViewModel
    var factory: UserVMFactory
    var adapter: UserAdapter

    /**
     * Pass a valid state to this method.
     * It will modify the view according to the state.
     */
    fun handleViewState(state: UserViewState)

    fun initRecyclerView()
}