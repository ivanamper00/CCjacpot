package com.giaidac.ccjackpot.presentation.fragments

import android.os.Bundle
import android.view.View
import com.giaidac.ccjackpot.presentation.adapter.ProcedureAdapter
import com.giaidac.ccjackpot.components.delegate.EventFlow
import com.giaidac.ccjackpot.components.SliderTransformer
import com.giaidac.common.DataContent
import com.giaidac.common.base.BaseFragment
import com.giaidac.common.binding.viewBinding
import com.giaidac.ccjackpot.R
import com.giaidac.ccjackpot.databinding.FragmentProceduresBinding


class ProceduresFragment : BaseFragment(R.layout.fragment_procedures), ProcedureAdapter.OnClickListener{

    val binding by viewBinding(FragmentProceduresBinding::bind)
    lateinit var procedureAdapter: ProcedureAdapter
    val delegate by lazy { requireActivity() as EventFlow }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        procedureAdapter = ProcedureAdapter(this)
        binding.viewPager.apply {
            adapter = procedureAdapter
            offscreenPageLimit = 3
            setPageTransformer(SliderTransformer(3))
        }
    }

    override fun onItemClick(content: DataContent) {
        delegate.description(content)
    }

}