package com.valko.scoot.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.valko.scoot.R
import com.valko.scoot.databinding.FragmentStep2Binding
import com.valko.scoot.viewmodels.Step2ViewModel

class Step2Fragment : Fragment() {

    private lateinit var binding: FragmentStep2Binding
    private lateinit var viewModel: Step2ViewModel


    private val clickListener = View.OnClickListener { view ->
        when(view.id){
            binding.backBtn.id -> viewModel.onBackPressed()
            binding.refreshIcon.id -> viewModel.onRefreshClick()
            binding.nextBtn.id -> viewModel.onNextClick()
        }
    }

    //-----------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[Step2ViewModel::class.java]
        viewModel.init(arguments)
        observeEvents()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        if (!::binding.isInitialized) {
            binding = FragmentStep2Binding.inflate(inflater)
            binding.viewModel = viewModel
            binding.lifecycleOwner = this

            binding.backBtn.setOnClickListener(clickListener)
            binding.refreshIcon.setOnClickListener(clickListener)
            binding.refreshText.setOnClickListener(clickListener)
            binding.nextBtn.setOnClickListener(clickListener)
        }
        return binding.root
    }

//-------------------------------------------------------------------------------

    private fun observeEvents(){
        viewModel.event.observe(this){event ->
            when(event.type){
                Step2ViewModel.Step2Events.RETURN_TO_PREV_FRAGMENT -> activity?.onBackPressed()
                Step2ViewModel.Step2Events.REFRESH_CAR -> refreshCar()
                Step2ViewModel.Step2Events.START_NEXT_FRAGMENT -> startNextFragment()
            }
        }
    }

    private fun refreshCar(){

    }

    private fun startNextFragment(){

    }

}