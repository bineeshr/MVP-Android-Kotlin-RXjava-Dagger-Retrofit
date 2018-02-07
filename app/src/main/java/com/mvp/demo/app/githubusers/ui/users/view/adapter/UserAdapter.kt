package com.mvp.demo.app.githubusers.ui.users.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvp.demo.app.githubusers.ui.users.model.User
import kotlinx.android.synthetic.main.adapter_user.view.*
import kotlin.mvp.demo.app.githubusers.R


/**
 * Created by bineesh on 6/2/18.
 */
class UserAdapter (var userList: MutableList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_user,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val user=userList.get(position)
        holder?.bindData(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(user: User) {
            itemView.git_user.text=user.login
        }

    }
    fun updateUserData(users: MutableList<User>){
        userList=users
        notifyDataSetChanged()
    }
}