package com.farmilify.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.regex.Matcher
import java.util.regex.Pattern


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
            message = msg ?: ""
        }.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        /*fun isValidPassword(password: String): Boolean {
            val pattern: Pattern
            val matcher: Matcher
            val specialCharacters = "-@%\\[\\}+'!/#$^?:;,\\(\"\\)~`.*=&\\{>\\]<_"
            val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$specialCharacters])(?=\\S+$).{8,20}$"
            pattern = Pattern.compile(PASSWORD_REGEX)
            matcher = pattern.matcher(password)
            return matcher.matches()
        } */


        val presenter = RegisterPresenter(this)
        btnRegister.onClick {
            val username = edtUsername.text.toString()
            val nama = edtName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            presenter.register(username, nama, email, password)


            /*val errorText = when {
                /* Rule 1 */
                !password.contains(Regex("[A-Z]")) -> "Password must contain one capital letter"
                /* Rule 2 */
                !password.contains(Regex("[0-9]")) -> "Password must contain one digit"
                /* Rule 3, not counting space as special character */
                !password.contains(Regex("[^a-zA-Z0-9 ]")) -> "Password must contain one special character"
                else -> null }*/


        }
    }
}



