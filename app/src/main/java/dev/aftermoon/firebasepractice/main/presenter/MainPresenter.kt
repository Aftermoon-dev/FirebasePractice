package dev.aftermoon.firebasepractice.main.presenter

import dev.aftermoon.firebasepractice.main.model.FirebaseUserModel


class MainPresenter: MainContract.Presenter {
    private var mainView: MainContract.View? = null
    override fun getUserInfo() {
        val userInfo = FirebaseUserModel.getUserInfo()
        mainView!!.showUserInfo(userInfo)
    }

    override fun createView(view: MainContract.View) {
        mainView = view
    }

    override fun destroyView() {
        mainView = null
    }

}