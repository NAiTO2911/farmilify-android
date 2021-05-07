package com.farmilify.client

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {

    fun register(username: String, nama: String, email: String, password: String) {
        NetworkConfigUser.service()
            ?.register(username, nama, email, password)
            ?.enqueue(object : Callback<ResultRegister> {
                override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                    registerView.onErrorRegister(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultRegister>,
                    response: Response<ResultRegister>
                ) {
                    if (response.body()?.status == 200) {
                        registerView.onSuccessRegister(response.message())
                    } else {
                        registerView.onErrorRegister(response.message())
                    }
                }
            })
    }
}