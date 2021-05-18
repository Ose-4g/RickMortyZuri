package com.ose4g.rickmortyzuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.getCharacters()
        }
    }
}