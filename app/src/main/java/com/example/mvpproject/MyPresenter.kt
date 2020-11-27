package com.example.mvpproject

class MyPresenter : BasePresenter {
    private var view: IView? = null

    override fun attachView(view: IView) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    fun displayText() {
        //We can get text from api call as well .
        //I am just using my hard coded text
        view?.displaytext(getData())

    }


}