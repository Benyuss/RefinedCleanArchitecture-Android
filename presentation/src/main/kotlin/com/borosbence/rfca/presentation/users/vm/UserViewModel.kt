package com.borosbence.rfca.presentation.users.vm

import androidx.lifecycle.MutableLiveData
import com.borosbence.rfca.domain.interactor.GetUsers
import com.borosbence.rfca.presentation.core.BaseViewModel
import com.borosbence.rfca.presentation.core.SingleLiveEvent
import com.borosbence.rfca.presentation.mapper.UserToUserModelMapper

/**
 * ViewModels responsibility is handling the view states.
 *
 * If everything is fine, it should provide the attached view state.
 * If an error happens, it couldn't provide that because something went wrong.
 * For this case, there is an error state.
 * In the error state you should stop displaying progress dialogs, showing loading animations, etc.. and inform the user there was an error and the view can not be loaded.
 */
class UserViewModel(private val getUsers: GetUsers,
                    private val mapper: UserToUserModelMapper) : BaseViewModel() {

    var viewState: MutableLiveData<UserViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        viewState.value = UserViewState()
    }

    fun getUsers() {
        addDisposable(getUsers.getAll()
                .map { mapper.mapFromList(it) }
                .subscribe({ users ->
                    viewState.value?.let {
                        val newState = this.viewState.value?.copy(showLoading = false, users = users)
                        this.viewState.value = newState
                        this.errorState.value = null
                    }
                }, {
                    viewState.value = viewState.value?.copy(showLoading = false)
                    errorState.value = it
                }))
    }
}