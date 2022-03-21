package com.giaidac.ccjackpot.presentation.fragments

import android.os.Bundle
import android.view.View
import com.giaidac.common.base.BaseFragment
import com.giaidac.common.binding.viewBinding
import com.giaidac.ccjackpot.R
import com.giaidac.ccjackpot.databinding.FragmentRulesBinding
import com.giaidac.ccjackpot.domain.SicboAssets


class RulesFragment : BaseFragment(R.layout.fragment_rules) {

    val binding by viewBinding(FragmentRulesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rules = SicboAssets.rules
    }

}