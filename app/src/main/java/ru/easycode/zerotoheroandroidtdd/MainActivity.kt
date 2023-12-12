package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var titleTextView: TextView
    private lateinit var actionButton: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as App).provideViewModel(MainViewModel::class.java)

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