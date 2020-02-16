package dev.aftermoon.firebasepractice.main.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dev.aftermoon.firebasepractice.R


class LoginPresenter: LoginContract.Presenter {
    private var loginView: LoginContract.View? = null

    override fun createView(view: LoginContract.View) {
        loginView = view
    }

    override fun destroyView() {
        loginView = null
    }

    override fun getGSO(gsoToken: String) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(gsoToken)
            .requestEmail()
            .build()
        loginView?.showGoogleLogin(gso)
    }
}