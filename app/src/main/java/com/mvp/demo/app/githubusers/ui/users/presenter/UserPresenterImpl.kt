package com.mvp.demo.app.githubusers.ui.users.presenter

import javax.inject.Inject
import com.mvp.demo.app.githubusers.base.presenter.BasePresenter
import com.mvp.demo.app.githubusers.ui.users.interactor.UserInteractor
import com.mvp.demo.app.githubusers.ui.users.view.UserView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by bineesh on 6/2/18.
 */
class UserPresenterImpl<V : UserView> @Inject constructor(var interactor: UserInteractor, var compositeDisposable: CompositeDisposable) : BasePresenter<V>(), UserPresenter<V> {


    fun getUserData() {
        compositeDisposable.add(interactor.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
            getView()?.getUserList(it)
        }, {
            getView()?.showError()
        }, {
            getView()?.hideProgress()
        })
        )
    }

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getView()?.showProgress()
        getUserData()

    }

    override fun onDeAttach() {
        compositeDisposable.dispose();
    }

}