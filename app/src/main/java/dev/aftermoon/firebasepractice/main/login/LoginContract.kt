package dev.aftermoon.firebasepractice.main.login

import dev.aftermoon.firebasepractice.BasePresenter
import dev.aftermoon.firebasepractice.BaseView

interface LoginContract {
    interface View: BaseView {
    }

    interface Presenter: BasePresenter<View> {
    }
}