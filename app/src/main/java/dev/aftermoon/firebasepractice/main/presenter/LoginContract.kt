package dev.aftermoon.firebasepractice.main.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dev.aftermoon.firebasepractice.BasePresenter
import dev.aftermoon.firebasepractice.BaseView

interface LoginContract {
    interface View: BaseView {
        fun setGoogleLogin(gso: GoogleSignInOptions)
    }

    interface Presenter: BasePresenter<View> {
        fun googleLogin(gsoToken: String)
        fun getAlreadyLogin(): Boolean
    }
}