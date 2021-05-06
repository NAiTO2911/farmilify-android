package com.farmilify.client

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class Login : AppCompatActivity() {
    var editEmail: EditText? = null
    var editPassword: EditText? = null
    var editName: EditText? = null
    var btnSignIn: Button? = null
    var btnRegister: Button? = null
    val url = "http://185.176.43.100/index.php"
    var jsonParser: JSONParser = JSONParser()
    var i = 0
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editEmail = findViewById(R.id.editEmail) as EditText?
        editName = findViewById(R.id.editName) as EditText?
        editPassword = findViewById(R.id.editPassword) as EditText?
        btnSignIn = findViewById(R.id.btnSignIn) as Button?
        btnRegister = findViewById(R.id.btnRegister) as Button?
        btnSignIn!!.setOnClickListener {
            val attemptLogin =
                AttemptLogin()
            attemptLogin.execute(
                editName!!.text.toString(),
                editPassword!!.text.toString(),
                ""
            )
        }
        btnRegister!!.setOnClickListener {
            if (i == 0) {
                i = 1
                editEmail!!.visibility = View.VISIBLE
                btnSignIn!!.visibility = View.GONE
                btnRegister!!.text = "CREATE ACCOUNT"
            } else {
                btnRegister!!.text = "REGISTER"
                editEmail!!.visibility = View.GONE
                btnSignIn!!.visibility = View.VISIBLE
                i = 0
                val attemptLogin =
                    AttemptLogin()
                attemptLogin.execute(
                    editName!!.text.toString(),
                    editPassword!!.text.toString(),
                    editEmail!!.text.toString()
                )
            }
        }
    }

    private inner class AttemptLogin :
        AsyncTask<String?, String?, JSONObject?>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        protected override fun doInBackground(vararg args: String): JSONObject? {
            val email = args[2]
            val password = args[1]
            val name = args[0]
            val params: ArrayList<NameValuePair> = ArrayList<NameValuePair>()
            params.add(BasicNameValuePair("username", name))
            params.add(BasicNameValuePair("password", password))
            if (email.length > 0) params.add(BasicNameValuePair("email", email))
            return jsonParser.makeHttpRequest(URL, "POST", params)
        }

        override fun onPostExecute(result: JSONObject?) {

            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            try {
                if (result != null) {
                    Toast.makeText(
                        getApplicationContext(),
                        result.getString("message"),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        getApplicationContext(),
                        "Unable to retrieve any data from server",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }
}