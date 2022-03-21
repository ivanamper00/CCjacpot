package com.giaidac.ccjackpot.presentation.fragments

import android.os.Bundle
import android.view.View
import com.giaidac.common.base.BaseFragment
import com.giaidac.common.binding.viewBinding
import com.giaidac.ccjackpot.R
import com.giaidac.ccjackpot.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment(R.layout.fragment_about) {

    val binding by viewBinding(FragmentAboutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}