package com.borosbence.rfca.presentation.users.view

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.borosbence.rfca.R
import com.borosbence.rfca.presentation.users.adapter.UserAdapter
import com.borosbence.rfca.presentation.users.presenter.UserPresenter
import com.borosbence.rfca.presentation.users.presenter.UserPresenterImpl

class UserActivity : AppCompatActivity(), UserView {

    private lateinit var presenter: UserPresenter
    private lateinit var viewHolder: UserView.UserViewHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        setContentView(R.layout.activity_main)
        initViewHolder()
        presenter.onCreate(savedInstanceState)
    }

    private fun initPresenter() {
        presenter = UserPresenterImpl(UserActivity@ this, this)
    }

    private fun initViewHolder() {
        viewHolder = getViewHolderInstance()
    }

    private fun getViewHolderInstance(): UserView.UserViewHolder {
        val rootView: View = window.decorView.findViewById(android.R.id.content)
        return UserView.UserViewHolder(rootView)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return presenter.onCreateOptions(menu)
    }

    override fun initRecyclerView(adapter: UserAdapter) {
        viewHolder.recyclerView!!.setEmptyView(viewHolder.emptyText!!)
        viewHolder.recyclerView!!.adapter = adapter
    }

    override fun setProgressBarVisibility(visibility: Int) {
        viewHolder.progressBar!!.visibility = visibility
    }

    override fun setRecyclerViewEmptyTextVisibility(visibility: Int) {
        viewHolder.emptyText!!.visibility = visibility
    }
}