package br.iesb.mobile.movieapi.repository

import android.content.Context
import br.iesb.mobile.movieapi.model.ResponseMovie
import br.iesb.mobile.movieapi.model.ResponseWapper
import br.iesb.mobile.movieapi.service.BaseRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface TmdbAPI {
    @GET("/3/discover/movie?certification_country=BR&apikey=04a3cca8188b6a40f7bc4ddf757b4132")
    fun brazilianMovies(): Call<ResponseWapper>

    @GET("/3/discover/movie?sort_by=popularity.desc&apikey=04a3cca8188b6a40f7bc4ddf757b4132")
    fun popularityMovies(): Call<ResponseWapper>

    @GET("/3/movie/{id}?apikey=04a3cca8188b6a40f7bc4ddf757b4132")
    fun findMovie(@Path("id") id: Number): Call<ResponseMovie>

}

class TmdbRepository(context: Context) : BaseRetrofit(context) {

    fun getBrazilianMovies(callback: (ResponseWapper?, Throwable?) -> Unit) {
        val api = retrofit.create(TmdbAPI::class.java)
        val call = api.brazilianMovies()

        call.enqueue(object : Callback<ResponseWapper> {
            override fun onResponse(call: Call<ResponseWapper>, response: Response<ResponseWapper>) {
                callback(response.body(),null)
            }
            override fun onFailure(call: Call<ResponseWapper>, t: Throwable) {
                callback(null, t)
            }
        })
    }

    fun getPopularityMovies(callback: (ResponseWapper?, Throwable?) -> Unit) {
        val api = retrofit.create(TmdbAPI::class.java)
        val call = api.popularityMovies()

        call.enqueue(object : Callback<ResponseWapper> {
            override fun onResponse(call: Call<ResponseWapper>, response: Response<ResponseWapper>) {
                callback(response.body(),null)
            }
            override fun onFailure(call: Call<ResponseWapper>, t: Throwable) {
                callback(null, t)
            }
        })
    }

    fun getFindMovie(id: Number, callback: (ResponseMovie?, Throwable?) -> Unit) {
        val api = retrofit.create(TmdbAPI::class.java)
        val call = api.findMovie(id)

        call.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                callback(response.body(),null)
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                callback(null, t)
            }
        })
    }
}