package com.farmilify.client

interface LoginView {
        fun onSuccessLogin(response:ResultLogin)
        fun onErrorLogin(msg : String?)
}