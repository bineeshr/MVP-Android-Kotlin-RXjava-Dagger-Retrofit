package com.mvp.demo.app.githubusers.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import com.mvp.demo.app.githubusers.app.GitApp
import com.mvp.demo.app.githubusers.di.builder.ActivityBuilder
import com.mvp.demo.app.githubusers.di.module.AppModule

/**
 * Created by bineesh on 6/2/18.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ActivityBuilder::class, AppModule::class))
interface AppComponent {

    @Component.Builder
interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun inject(app: GitApp)
}