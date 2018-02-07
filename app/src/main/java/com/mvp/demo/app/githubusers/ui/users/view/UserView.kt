package com.mvp.demo.app.githubusers.ui.users.view

import com.mvp.demo.app.githubusers.base.view.BaseView
import com.mvp.demo.app.githubusers.ui.users.model.User

/**
 * Created by bineesh on 6/2/18.
 */
interface UserView: BaseView {
    fun getUserList(mutableList: MutableList<User>)

}