package com.giaidac.ccjackpot.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.giaidac.common.DataContent
import com.giaidac.common.base.BaseFragment
import com.giaidac.common.binding.viewBinding
import com.giaidac.ccjackpot.R
import com.giaidac.ccjackpot.databinding.FragmentDescriptionBinding
import com.google.gson.Gson

class DescriptionFragment : BaseFragment(R.layout.fragment_description) {

    val binding by viewBinding(FragmentDescriptionBinding::bind)
    val args: DescriptionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.description = Gson().fromJson(args.dataContent, DataContent::class.java)
    }

}