package com.example.movieproject.ui.fragments.movie

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieproject.R
import com.example.movieproject.base.BaseFragmentMyVersion
import com.example.movieproject.databinding.FragmentMovieBinding
import com.example.movieproject.ui.adapters.MovieAdapter

class MovieFragment : BaseFragmentMyVersion<FragmentMovieBinding>(R.layout.fragment_movie) {

    override val binding by viewBinding(FragmentMovieBinding::bind)
    private val viewModel: MovieViewModel by viewModels()

    override fun initMV() {

        viewModel.getMovies()
        viewModel.movieList.observe(this, {
            binding.recView.apply {
                adapter = MovieAdapter(it, this@MovieFragment::openDetail)
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
        })
    }

    private fun openDetail(id: Int) {
        findNavController().navigate(
            MovieFragmentDirections.actionMovieFragmentToGetDetailFragment(id)
        )
    }
}