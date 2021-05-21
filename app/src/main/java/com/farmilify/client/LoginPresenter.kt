package com.farmilify.client

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: LoginView) {

    fun login(username: String, password: String) {
        NetworkConfigUser.service2()
            ?.login(username,password)
            ?.enqueue(object : Callback<ResultLogin> {
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultLogin>,
                    response: Response<ResultLogin>
                ) {
                    if (response.body()?.status == 200) {
                        loginView.onSuccessLogin(response.body()!!)
                    } else {
                        loginView.onErrorLogin(response.message())
                    }
                }
            })
    }
}