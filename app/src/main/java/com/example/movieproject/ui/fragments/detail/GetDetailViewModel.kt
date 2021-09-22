package com.example.movieproject.ui.fragments.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieproject.api.RetrofitClient
import com.example.movieproject.base.BaseViewModel
import com.example.movieproject.model.Movie
import kotlinx.coroutines.launch

class GetDetailViewModel : BaseViewModel() {

    val movies = MutableLiveData<Movie>()

    fun getMovieDetail(id: Int) {
        uiScope.launch {
            RetrofitClient.apiService.getDetailMovies(id).let {
                if (it.isSuccessful) {
                    movies.value = it.body()
                } else {
                    Log.e("tag", "getMovie : Error ${it.code()}")
                }
            }
        }

    }


}