package com.valko.scoot.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.valko.scoot.R
import com.valko.scoot.databinding.FragmentStep1Binding
import com.valko.scoot.extensions.startFragment
import com.valko.scoot.viewmodels.Step1ViewModel

class Step1Fragment : Fragment() {

    private lateinit var binding: FragmentStep1Binding
    private lateinit var viewModel: Step1ViewModel

    private val clickListener = View.OnClickListener { view ->
        when(view.id){
            binding.nextBtn.id -> viewModel.onNextClick(binding.regNumberInput.text.toString())
        }

    }

    //--------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[Step1ViewModel::class.java]
        viewModel.init()
        observeEvents()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        if (!::binding.isInitialized) {
            binding = FragmentStep1Binding.inflate(inflater)
            binding.nextBtn.setOnClickListener(clickListener)
        }

        return binding.root
    }
//--------------------------------------------------------------------------------------------

    private fun observeEvents() {
        viewModel.event.observe(this) { event ->
            when (event.type) {
                Step1ViewModel.Step1Events.START_NEXT_FRAGMENT -> onNextFragmentEvent(event.data as Bundle)
            }
        }
    }

    private fun onNextFragmentEvent(args: Bundle){
        val fragment = Step2Fragment()
        fragment.arguments = args
        startFragment(fragment, R.id.main_container, setAnimation = true, addToBackStack =  true)
    }

}