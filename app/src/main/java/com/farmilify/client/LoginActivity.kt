package com.farmilify.client

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity(), LoginView {
    override fun onSuccessLogin(response: ResultLogin) {
        alert {
            title = "Selamat, anda berhasil masuk !"
            message = response.message.toString()
        }.show()
        val sharedPreferences = this@LoginActivity.getSharedPreferences("mysharedpref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("hasLogin", true)
        editor.putString("username", response.user?.username )
        editor.apply()
        editor.commit()
        val intent = Intent(this, Dashboard::class.java)
        startActivity(intent)
        finish()
    }


    override fun onErrorLogin(msg: String?) {
        alert {
            title = "Akun gagal masuk !"
            message = msg ?: ""
        }.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val presenter = LoginPresenter(this)
        btnLogin.onClick {
            val username = edtUsernameLogin.text.toString()
            val password = edtPasswordLogin.text.toString()

            presenter.login(username, password)


        }
    }
}



