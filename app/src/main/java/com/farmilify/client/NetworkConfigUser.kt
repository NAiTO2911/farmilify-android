package com.farmilify.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkConfigUser {
        private fun getInterceptor(): OkHttpClient {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .build()
        }

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://192.168.0.104/server_farmilify/index.php/Api/")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun service(): RegisterService? = getRetrofit().create(RegisterService::class.java)
    }
