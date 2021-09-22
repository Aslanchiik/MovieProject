package com.example.movieproject.ui.fragments.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieproject.api.RetrofitClient
import com.example.movieproject.base.BaseViewModel
import com.example.movieproject.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel : BaseViewModel() {

    val movieList = MutableLiveData<List<Movie>>()

      fun getMovies () {
          uiScope.launch {
              RetrofitClient.apiService.getMovies().let {
                   if (it.isSuccessful) {
                       movieList.value = it.body()
                   }  else {
                       Log.e("tag", "movie : Error ${it.code()}")
                   }
              }
          }
      }
}