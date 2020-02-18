package dev.aftermoon.firebasepractice.main.presenter

import dev.aftermoon.firebasepractice.BasePresenter
import dev.aftermoon.firebasepractice.BaseView
import dev.aftermoon.firebasepractice.main.model.FirebaseUserInfo

interface MainContract {
    interface View: BaseView {
        fun showUserInfo(userInfo: List<FirebaseUserInfo>)
    }

    interface Presenter: BasePresenter<View> {
        fun getUserInfo()
    }
}