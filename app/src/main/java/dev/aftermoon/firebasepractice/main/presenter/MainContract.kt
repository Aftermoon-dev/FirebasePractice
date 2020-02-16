package dev.aftermoon.firebasepractice.main.presenter

import com.google.firebase.auth.FirebaseUser
import dev.aftermoon.firebasepractice.BasePresenter
import dev.aftermoon.firebasepractice.BaseView

interface MainContract {
    interface View: BaseView {
        fun showUserEmail(userInfo: FirebaseUser?)
    }

    interface Presenter: BasePresenter<View> {
        fun getUserInfo()
    }
}