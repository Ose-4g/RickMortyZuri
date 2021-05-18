package com.ose4g.rickmortyzuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ose4g.rickmortyzuri.adapters.CharacterListAdapter
import com.ose4g.rickmortyzuri.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val context = this
        val pagingAdapter = CharacterListAdapter(context)
        binding.characterList.let {
            it.adapter = pagingAdapter
            it.layoutManager = GridLayoutManager(context,2)
            it.setHasFixedSize(true)
        }

        lifecycleScope.launch {
            viewModel.characters.collectLatest { pagedData ->
                pagingAdapter.submitData(pagedData)
            }
        }
    }
}