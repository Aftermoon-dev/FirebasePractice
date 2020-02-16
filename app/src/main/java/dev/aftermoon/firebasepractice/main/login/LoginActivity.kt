package dev.aftermoon.firebasepractice.main.login

import android.os.Bundle
import dev.aftermoon.firebasepractice.BaseActivity
import dev.aftermoon.firebasepractice.R

class LoginActivity : BaseActivity(),
    LoginContract.View {
    private lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter.createView(this)
    }

    override fun initPresenter() {
       loginPresenter = LoginPresenter()
    }
}
