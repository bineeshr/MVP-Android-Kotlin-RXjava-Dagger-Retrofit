package com.mvp.demo.app.githubusers.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.mvp.demo.app.githubusers.api.ApiHelper
import com.mvp.demo.app.githubusers.util.AppConstant

/**
 * Created by bineesh on 6/2/18.
 */
@Module
class AppModule {
    @Singleton
    @Provides
    fun application(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Singleton
    @Provides
    fun provideGsonConvertFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(logging)
                .readTimeout(60, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: GsonConverterFactory, adapter: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
                .client(client).addConverterFactory(gson)
                .addCallAdapterFactory(adapter).build()
    }

    @Singleton
    @Provides
    fun provideApiHelper(retrofit: Retrofit): ApiHelper {
        return retrofit.create(ApiHelper::class.java)
    }
}