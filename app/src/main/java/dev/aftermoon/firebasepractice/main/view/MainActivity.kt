package dev.aftermoon.firebasepractice.main.view

import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseUser
import dev.aftermoon.firebasepractice.BaseActivity
import dev.aftermoon.firebasepractice.R
import dev.aftermoon.firebasepractice.main.presenter.MainContract
import dev.aftermoon.firebasepractice.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.createView(this)
        mainPresenter.getUserInfo()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.destroyView()
    }

    override fun initPresenter() {
        mainPresenter = MainPresenter()
    }

    override fun showUserEmail(userInfo: FirebaseUser?) {
        Log.d("MainActivity", "${userInfo?.displayName} / ${userInfo?.email}")
        emailAddress.text = "Display Name : ${userInfo?.displayName}\nEmail : ${userInfo?.email}"
    }
}