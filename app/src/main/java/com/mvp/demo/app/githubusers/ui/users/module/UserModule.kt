package com.mvp.demo.app.githubusers.ui.users.module

import dagger.Binds
import dagger.Module
import com.mvp.demo.app.githubusers.ui.users.interactor.UserInteractor
import com.mvp.demo.app.githubusers.ui.users.interactor.UserInteractorImpl
import com.mvp.demo.app.githubusers.ui.users.presenter.UserPresenter
import com.mvp.demo.app.githubusers.ui.users.presenter.UserPresenterImpl
import com.mvp.demo.app.githubusers.ui.users.view.UserView

/**
 * Created by bineesh on 6/2/18.
 */
@Module
abstract class UserModule {
    @Binds
    abstract fun provideUserInteractor(userInteractorImpl: UserInteractorImpl): UserInteractor

    @Binds
    abstract fun provideUserPresenter(userPresenterImpl: UserPresenterImpl<UserView>): UserPresenter<UserView>
}