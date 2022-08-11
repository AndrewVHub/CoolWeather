package com.example.coolweather.presentation.ui.added

import android.util.Log
import com.example.coolweather.databinding.FragmentAddedBinding
import com.example.coolweather.presentation.ui.base.BaseFragment

class AddedFragment : BaseFragment<FragmentAddedBinding>( FragmentAddedBinding::inflate) {
    override fun FragmentAddedBinding.initialize() {
        Log.e("TAG", "aa")
    }

}