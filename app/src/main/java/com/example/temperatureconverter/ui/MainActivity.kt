package com.example.temperatureconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.temperatureconverter.R
import com.example.temperatureconverter.databinding.ActivityMainBinding
import com.example.temperatureconverter.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel :MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .also { binding ->
                binding.viewModel=this.viewModel
                binding.lifecycleOwner=this
            }
    }
}