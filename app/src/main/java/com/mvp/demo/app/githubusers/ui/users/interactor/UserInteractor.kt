package com.mvp.demo.app.githubusers.ui.users.interactor

import com.mvp.demo.app.githubusers.ui.users.model.User
import io.reactivex.Observable

/**
 * Created by bineesh on 6/2/18.
 */
interface UserInteractor {
    fun getUsers():Observable<MutableList<User>>
}