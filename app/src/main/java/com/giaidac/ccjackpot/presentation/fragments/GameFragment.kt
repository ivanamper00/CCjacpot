package com.giaidac.ccjackpot.presentation.fragments

import android.os.Bundle
import android.view.View
import com.giaidac.ccjackpot.domain.SicboAssets
import com.giaidac.common.base.BaseFragment
import com.giaidac.common.binding.viewBinding
import com.giaidac.ccjackpot.R
import com.giaidac.ccjackpot.databinding.FragmentGameBinding

class GameFragment : BaseFragment(R.layout.fragment_game) {

    val binding by viewBinding(FragmentGameBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.game = SicboAssets.about
    }

}