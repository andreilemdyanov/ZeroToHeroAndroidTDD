package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var actionButton: Button
    private lateinit var progressBar: ProgressBar
    private val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)
        progressBar = findViewById(R.id.progressBar)

        actionButton.setOnClickListener {
            viewModel.load()
        }

        viewModel.observe(this) {
            it.apply(titleTextView, actionButton, progressBar)
        }
    }
}