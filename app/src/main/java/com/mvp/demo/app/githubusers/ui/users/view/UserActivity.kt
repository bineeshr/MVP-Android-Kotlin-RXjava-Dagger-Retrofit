package com.mvp.demo.app.githubusers.ui.users.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlin.mvp.demo.app.githubusers.R
import com.mvp.demo.app.githubusers.base.view.BaseActivity
import com.mvp.demo.app.githubusers.ui.users.model.User
import com.mvp.demo.app.githubusers.ui.users.presenter.UserPresenter
import com.mvp.demo.app.githubusers.ui.users.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : BaseActivity(), UserView {

  @Inject  lateinit var userPresenter: UserPresenter<UserView>
    private lateinit var mUserAdapter: UserAdapter
    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        super.onViewReady(savedInstanceState, intent)
        userPresenter.onAttach(this)
        mUserAdapter = UserAdapter(mutableListOf())
        val mLayoutManager = LinearLayoutManager(applicationContext)
        user_list.layoutManager = mLayoutManager
        val dividerItemDecoration = DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        user_list.addItemDecoration(dividerItemDecoration)
        user_list.itemAnimator = DefaultItemAnimator()
        user_list.adapter = mUserAdapter
    }

    override fun hideProgress() {
        progress.visibility = View.GONE

    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun getUserList(users: MutableList<User>) {
        mUserAdapter.updateUserData(users)

    }

    override fun getContentView(): Int {
        return R.layout.activity_user
    }

    override fun showError() {

    }
}
