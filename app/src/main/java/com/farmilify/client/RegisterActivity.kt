package com.farmilify.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick


class RegisterActivity : AppCompatActivity(), RegisterView {
    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Pesan"
            message = msg ?: ""
        }.show()
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Gagal"
            message = msg ?:""
        }.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val presenter = RegisterPresenter(this)
        btnRegister.onClick {
            val nama  = edtName.text.toString()
            val email  = edtEmail.text.toString()
            val username  = edtUsername.text.toString()
            val password  = edtPassword.text.toString()

            presenter.register(nama, email, username, password)

        }
    }
}
