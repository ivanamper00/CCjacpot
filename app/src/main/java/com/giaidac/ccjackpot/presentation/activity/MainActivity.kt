package com.giaidac.ccjackpot.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.giaidac.common.DataContent
import com.giaidac.common.base.BaseActivity
import com.giaidac.common.event.UiEvent
import com.giaidac.common.ui.ActivityEvent
import com.giaidac.common.ui.ActivityViewModel
import com.giaidac.ccjackpot.R
import com.giaidac.ccjackpot.databinding.ActivityMainBinding
import com.giaidac.ccjackpot.components.delegate.EventFlow
import com.giaidac.ccjackpot.presentation.fragments.ProceduresFragmentDirections
import com.google.gson.Gson

class MainActivity : BaseActivity(), EventFlow {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ActivityViewModel>()
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
    }
    private val navController get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val inflater = LayoutInflater.from(this)
        binding = ActivityMainBinding.inflate(inflater, null, false)
        setContentView(binding.root)

        navController.setGraph(R.navigation.navigation_graph)

        setupWithNavController(binding.bottomNavigationView, navController)
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId != binding.bottomNavigationView.selectedItemId) onNavDestinationSelected(
                item,
                navController
            )
            true
        }

        viewModel.activityEvent.observe(this){
            when(it){
                is UiEvent.Loading -> showLoading(it.isLoading)
                is ActivityEvent.ProcedurePage -> navController.navigate(R.id.proceduresFragment)
            }
        }

    }

    private fun setHideBottomNav(isHidden: Boolean) {
        binding.bottomNavigationView.visibility = if (isHidden) View.GONE else View.VISIBLE
    }

    override fun description(data: DataContent) {
        val direction = ProceduresFragmentDirections.navigateToDescription(Gson().toJson(data))
        navController.navigate(direction)
    }


    companion object{
        fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

}