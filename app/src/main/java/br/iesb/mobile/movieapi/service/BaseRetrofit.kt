package br.iesb.mobile.movieapi.service

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRetrofit(context: Context) {
    val retrofit: Retrofit
    val gson: Gson

    init {
        gson = GsonBuilder()
            .setDateFormat("dd-MM-yyyy")
            .create()


        retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun toJson(obj: Any): String = gson.toJson(obj)
    inline fun <reified T> fromJson(json: String) = gson.fromJson(json, T::class.java)
}


