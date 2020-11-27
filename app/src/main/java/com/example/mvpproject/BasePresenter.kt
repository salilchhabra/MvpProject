package com.example.mvpproject

interface BasePresenter {
    fun attachView(view: IView)
    fun detachView()
}