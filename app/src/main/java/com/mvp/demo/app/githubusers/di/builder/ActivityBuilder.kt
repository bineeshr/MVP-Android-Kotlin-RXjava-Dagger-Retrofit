package com.mvp.demo.app.githubusers.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.mvp.demo.app.githubusers.ui.users.view.UserActivity
import com.mvp.demo.app.githubusers.ui.users.module.UserModule

/**
 * Created by bineesh on 6/2/18.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(UserModule::class))
    abstract fun bindUserActivity(): UserActivity
}