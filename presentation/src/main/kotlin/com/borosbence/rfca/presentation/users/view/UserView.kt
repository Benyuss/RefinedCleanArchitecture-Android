package com.borosbence.rfca.presentation.users.view

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.borosbence.rfca.R
import com.borosbence.rfca.presentation.customView.RecyclerViewEmptySupport
import com.borosbence.rfca.presentation.users.adapter.UserAdapter

/**
 * Represents the view where we show a list of the users.
 */
interface UserView {

    /**
     * Init our recycler view with attaching an adapter
     */
    fun initRecyclerView(adapter: UserAdapter)

    /**
     * Init our recycler views empty text.
     * This text will be displayed when there are no elements in the adapter.
     */
    fun setRecyclerViewEmptyTextVisibility(visibility: Int)

    /**
     * Set visibility of our loading animation.
     */
    fun setProgressBarVisibility(visibility: Int)

    class UserViewHolder(view: View) {

        @JvmField
        @BindView(R.id.user_list)
        var recyclerView: RecyclerViewEmptySupport? = null

        @JvmField
        @BindView(R.id.user_list_empty)
        var emptyText: TextView? = null

        @JvmField
        @BindView(R.id.user_progress_bar)
        var progressBar: ProgressBar? = null

        init {
            ButterKnife.bind(this, view)
        }
    }
}