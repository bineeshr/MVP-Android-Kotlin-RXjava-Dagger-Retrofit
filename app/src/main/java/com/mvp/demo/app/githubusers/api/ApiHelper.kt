package com.mvp.demo.app.githubusers.api

import com.mvp.demo.app.githubusers.ui.users.model.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by bineesh on 6/2/18.
 */
interface ApiHelper {
    @GET("/users")
    fun getGitUser(): Observable<MutableList<User>>
}