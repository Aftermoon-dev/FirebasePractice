package dev.aftermoon.firebasepractice.main.presenter

import com.google.firebase.auth.FirebaseAuth

class MainPresenter: MainContract.Presenter {
    private var mainView: MainContract.View? = null
    override fun getUserInfo() {
        val user = FirebaseAuth.getInstance().currentUser
        mainView!!.showUserEmail(user)
    }

    override fun createView(view: MainContract.View) {
        mainView = view
    }

    override fun destroyView() {
        mainView = null
    }

}