package dev.aftermoon.firebasepractice.main.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import dev.aftermoon.firebasepractice.main.model.FirebaseUserModel

class LoginPresenter: LoginContract.Presenter {
    private var loginView: LoginContract.View? = null

    override fun createView(view: LoginContract.View) {
        loginView = view
    }

    override fun destroyView() {
        loginView = null
    }

    override fun googleLogin(gsoToken: String) {
        val gso = FirebaseUserModel.requestGSO(gsoToken)!!
        loginView?.setGoogleLogin(gso)
    }

    override fun getAlreadyLogin(): Boolean {
        return FirebaseUserModel.checkAlreadyLogin()
    }
}