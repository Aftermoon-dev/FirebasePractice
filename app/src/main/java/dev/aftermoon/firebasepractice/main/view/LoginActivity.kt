package dev.aftermoon.firebasepractice.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dev.aftermoon.firebasepractice.BaseActivity
import dev.aftermoon.firebasepractice.R
import dev.aftermoon.firebasepractice.main.presenter.LoginContract
import dev.aftermoon.firebasepractice.main.presenter.LoginPresenter
import dev.aftermoon.firebasepractice.util.Util
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {
    private lateinit var loginPresenter: LoginPresenter
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter.createView(this)
        auth = FirebaseAuth.getInstance()
        setButton()
    }

    override fun onStart() {
        super.onStart()

        if (loginPresenter.getAlreadyLogin()) {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.destroyView()
    }

    override fun initPresenter() {
       loginPresenter = LoginPresenter()
    }

    private fun setButton() {
        sign_in_button.setOnClickListener {
            loginPresenter.googleLogin(getString(R.string.default_web_client_id))
        }
    }

    override fun setGoogleLogin(gso: GoogleSignInOptions) {
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, Util.RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Util.RC_SIGN_IN) {
            val googleSignOnTask: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(googleSignOnTask)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Log.d("LoginActivity", "Sign In Success!")
            Toast.makeText(this, "구글에 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            firebaseAuthWithGoogle(account!!)
        } catch (e: ApiException) {
            Log.w("LoginActivity", "Sign In Failed! Error Code : " + e.statusCode)
            Toast.makeText(this, "구글 로그인에 실패하였습니다!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential =  GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("LoginActivity", "Firebase Auth Complete!")
                    val mainIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
                else {
                    Toast.makeText(this, "서버 로그인에 실패했습니다!", Toast.LENGTH_SHORT).show()
                    Log.w("LoginActivity", "Firebase Auth Failed!")
                }
            }
    }
}
