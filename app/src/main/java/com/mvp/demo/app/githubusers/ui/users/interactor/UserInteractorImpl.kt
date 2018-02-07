package com.mvp.demo.app.githubusers.ui.users.interactor

import android.content.Context
import com.mvp.demo.app.githubusers.api.ApiHelper
import com.mvp.demo.app.githubusers.ui.users.interactor.UserInteractor
import com.mvp.demo.app.githubusers.ui.users.model.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by bineesh on 6/2/18.
 */
class UserInteractorImpl @Inject constructor(var apiHelper: ApiHelper): UserInteractor {
    override fun getUsers(): Observable<MutableList<User>> {
      return  apiHelper.getGitUser()
    }


}