package dev.aftermoon.firebasepractice.main.login

import dev.aftermoon.firebasepractice.main.login.LoginContract

class LoginPresenter: LoginContract.Presenter {
    private var loginView: LoginContract.View? = null

    override fun createView(view: LoginContract.View) {
        loginView = view
    }

    override fun destroyView() {
        loginView = null
    }

}