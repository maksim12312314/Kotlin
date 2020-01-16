package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityViewmodel : ViewModel() {
    private var _grap:MutableLiveData<Int> = MutableLiveData( 0)

    var grap:LiveData<Int> = _grap

    fun increaseGrap() {
        _grap.value = ( _grap.value ?: 0 ) + 1
    }
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MainActivityViewmodel::class.java)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = model
        binding.lifecycleOwner = this
    }
}
