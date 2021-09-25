package com.example.movieproject.ui.fragments.nointernet

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieproject.R
import com.example.movieproject.base.BaseFragmentMyVersion
import com.example.movieproject.databinding.FragmentNoInternetBinding
import com.example.movieproject.newtork.NetworkIsConnect

class NoInternetFragment :
    BaseFragmentMyVersion<FragmentNoInternetBinding>(R.layout.fragment_no_internet) {

    override val binding by viewBinding(FragmentNoInternetBinding::bind)

    override fun setupView() {
        NetworkIsConnect(context ?: return).observe(viewLifecycleOwner, { isConnect ->
            if (isConnect == true) {
                findNavController().navigateUp()
            }
        }
        )
    }
}