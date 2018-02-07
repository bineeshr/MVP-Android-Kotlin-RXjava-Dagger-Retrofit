package com.mvp.demo.app.githubusers.base.presenter

import com.mvp.demo.app.githubusers.base.view.BaseView

/**
 * Created by bineesh on 6/2/18.
 */
open class BasePresenter<V: BaseView>:MVPPresenter<V> {
    override fun onDeAttach() {
    }

    private var view: V?=null
    override fun onAttach(view:V?) {
        this.view=view;
    }

    override fun getView(): V? {
        return view
    }
}