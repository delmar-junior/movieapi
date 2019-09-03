package br.iesb.mobile.movieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.iesb.mobile.movieapi.repository.TmdbRepository

class MainActivity : AppCompatActivity() {

    private val repository : TmdbRepository by lazy { TmdbRepository(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        repository.getBrazilianMovies { responseWapper, throwable ->
            Log.d("Brasilian Movies",responseWapper.toString())
        }

        repository.getPopularityMovies { responseWapper, throwable ->
            Log.d("Popularity Movies",responseWapper.toString())
        }

        repository.getFindMovie(420818) { responseMovie, throwable ->
            Log.d("Get Movie",responseMovie.toString())
        }
    }
}
