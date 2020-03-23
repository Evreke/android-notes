package ru.evreke.myapplication

import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    inline fun<reified T> apiFrom(url: String): T =
        Retrofit.Builder()
            .baseUrl(url)
            .client(client("alex", "Alex333"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)


    fun client(login: String, password: String): OkHttpClient =
        OkHttpClient
            .Builder()
            .authenticator { _, response ->
                response.request().newBuilder().header("Authorization", Credentials.basic(login, password)).build()
            }.build()

}