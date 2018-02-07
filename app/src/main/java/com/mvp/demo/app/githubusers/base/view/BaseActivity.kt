package com.mvp.demo.app.githubusers.base.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by bineesh on 6/2/18.
 */
abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(getContentView())
        onViewReady(savedInstanceState,intent)
    }

    open fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {

    }

    abstract fun getContentView(): Int
}