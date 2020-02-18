package dev.aftermoon.firebasepractice.main.model

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

object FirebaseUserModel {
    fun requestGSO(gsoToken: String): GoogleSignInOptions? {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(gsoToken)
            .requestEmail()
            .build()
    }

    fun checkAlreadyLogin(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }

    fun getUserInfo(): List<FirebaseUserInfo> {
        val user = FirebaseAuth.getInstance().currentUser
        return if (user != null) listOf(FirebaseUserInfo(user.displayName!!, user.email!!))
        else listOf(FirebaseUserInfo("", ""))
    }
}