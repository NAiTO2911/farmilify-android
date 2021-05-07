package com.farmilify.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick


class RegisterActivity : AppCompatActivity(), RegisterView {
     override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Selamat, Akun anda berhasil dibuat !"
            message = msg ?: ""
        }.show()
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Akun gagal dibuat !"
            message = msg ?:""
        }.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val presenter = RegisterPresenter(this)
        btnRegister.onClick {
            val username  = edtUsername.text.toString()
            val nama  = edtName.text.toString()
            val email  = edtEmail.text.toString()
            val password  = edtPassword.text.toString()

            presenter.register(username, nama, email, password)

        }
    }
}
