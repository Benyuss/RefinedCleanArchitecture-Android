package com.borosbence.rfca.presentation.users.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.borosbence.rfca.R
import com.borosbence.rfca.presentation.model.UserModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * RecyclerView adapter to represent [UserModel]s.
 */
class UserAdapter(private var context: Context) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private val dataSet: MutableList<UserModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val dynamicPosition: Int = holder.adapterPosition
        val user: UserModel = dataSet[dynamicPosition]

        setTexts(holder, user)
        setImage(holder, user)
    }

    private fun setTexts(holder: UserHolder, user: UserModel) {
        holder.name!!.text = user.name
        holder.email!!.text = user.email
    }

    private fun setImage(holder: UserHolder, user: UserModel) {
        Glide.with(context).load(user.profilePicture)
                .apply(RequestOptions().centerCrop())
                .into(holder.profilePicture!!)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun addUsers(list: List<UserModel>) {
        this.dataSet.clear()
        this.dataSet.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @JvmField
        @BindView(R.id.user_name)
        var name: TextView? = null

        @JvmField
        @BindView(R.id.user_email)
        var email: TextView? = null

        @JvmField
        @BindView(R.id.user_image)
        var profilePicture: ImageView? = null

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}