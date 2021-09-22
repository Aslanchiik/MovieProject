package com.example.movieproject.ui.fragments.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.movieproject.R
import com.example.movieproject.base.BaseFragmentMyVersion
import com.example.movieproject.databinding.FragmentGetDetailBinding

class GetDetailFragment :
    BaseFragmentMyVersion<FragmentGetDetailBinding>(R.layout.fragment_get_detail) {

    override val binding by viewBinding(FragmentGetDetailBinding::bind)
    private val viewModel: GetDetailViewModel by viewModels()
    private val args: GetDetailFragmentArgs by navArgs()

    var id: Int? = null

    override fun setupView() {
        id = args.model
        getData()
    }

    private fun getData() {
        id?.let { viewModel.getMovieDetail(it) }
        viewModel.movies.observe(viewLifecycleOwner, { getModel ->
            binding.mainPoster.load(getModel.image.original) {
                crossfade(true)
                crossfade(1000)
            }
            binding.ratingStar.text = getModel.rating.toString()
            binding.genresOfFilm.text = getModel.genres.toString()
            binding.statusOfFilm.text = getModel.status
            binding.descriptionText.text = getModel.summary
        })
    }
}