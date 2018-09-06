package com.borosbence.rfca.presentation.users.presenter

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.borosbence.rfca.R
import com.borosbence.rfca.api.rx.SafeObserver
import com.borosbence.rfca.domain.interactor.GetUsers
import com.borosbence.rfca.domain.model.User
import com.borosbence.rfca.presentation.core.CleanApplication
import com.borosbence.rfca.presentation.model.UserModel
import com.borosbence.rfca.presentation.users.adapter.UserAdapter
import com.borosbence.rfca.presentation.users.view.UserView
import com.borosbence.rfca.presentation.users.vm.UserVMFactory
import com.borosbence.rfca.presentation.users.vm.UserViewModel
import com.borosbence.rfca.presentation.users.vm.UserViewState
import javax.inject.Inject

/**
 *
 */
class UserPresenterImpl(override var activity: AppCompatActivity, val view: UserView) : UserPresenter {

    @Inject
    lateinit var interactor: GetUsers

    override lateinit var viewModel: UserViewModel

    @Inject
    override lateinit var factory: UserVMFactory

    override lateinit var adapter: UserAdapter

    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity.application as CleanApplication).createUserComponent().inject(this)
        viewModel = ViewModelProviders.of(activity, factory).get(UserViewModel::class.java)

        if (savedInstanceState == null) {
            interactor.getAll()
                    .subscribe(object : SafeObserver<List<User>>() {
                        override fun onNext(t: List<User>) {
                            viewModel.getUsers()
                        }
                    })
        }

        initRecyclerView()
    }

    override fun initRecyclerView() {
        adapter = UserAdapter(activity)
        view.initRecyclerView(adapter)
    }

    override fun onStart() {
        viewModel.viewState.observe(activity, Observer {
            if (it != null) handleViewState(it)
        })
        viewModel.errorState.observe(activity, Observer { throwable ->
            throwable?.let {
                Log.e(UserPresenterImpl::class.java.simpleName, it.message)
            }
        })
    }

    override fun handleViewState(state: UserViewState) {
        if (state.showLoading) {
            view.setProgressBarVisibility(View.VISIBLE)
            view.setRecyclerViewEmptyTextVisibility(View.GONE)
        } else {
            view.setProgressBarVisibility(View.GONE)
            view.setRecyclerViewEmptyTextVisibility(View.VISIBLE)
        }
        state.users?.let { adapter.addUsers(it) }
    }

    override fun onCreateOptions(menu: Menu): Boolean {
        createMenu(menu)
        setSearchListeners()

        return true
    }

    private fun createMenu(menu: Menu) {
        activity.menuInflater.inflate(R.menu.toolbar_menu, menu)
        val search = menu.findItem(R.id.action_search)
        searchView = search.actionView as SearchView
    }

    private fun setSearchListeners() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isNotBlank()) {
                    val sortedList = viewModel.viewState.value?.users?.filter { userModel ->
                        filterUsersByEmailAndName(userModel, newText)
                    }
                    adapter.addUsers(sortedList!!)
                    adapter.notifyDataSetChanged()
                }

                return true
            }
        })
    }

    private fun filterUsersByEmailAndName(user: UserModel, filter: String): Boolean {
        return user.name.contains(filter, true) || user.email.contains(filter, true)
    }
}