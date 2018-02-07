package com.mvp.demo.app.githubusers.base.presenter

import com.mvp.demo.app.githubusers.base.view.BaseView

/**
 * Created by bineesh on 6/2/18.
 */
interface MVPPresenter<V: BaseView> {
    fun onAttach(view:V?)
    fun getView():V?
    fun onDeAttach ()
}