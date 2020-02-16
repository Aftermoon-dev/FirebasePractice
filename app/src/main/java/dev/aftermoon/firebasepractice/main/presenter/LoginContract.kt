package dev.aftermoon.firebasepractice.main.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dev.aftermoon.firebasepractice.BasePresenter
import dev.aftermoon.firebasepractice.BaseView

interface LoginContract {
    interface View: BaseView {
        fun showGoogleLogin(gso: GoogleSignInOptions)
    }

    interface Presenter: BasePresenter<View> {
        fun getGSO(gsoToken: String)
    }
}