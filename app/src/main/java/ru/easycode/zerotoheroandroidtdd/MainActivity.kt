package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var state: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val actionButton = findViewById<Button>(R.id.actionButton)

        state = UiState.Initial
        state.apply(titleTextView, progress, actionButton)

        actionButton.setOnClickListener {
            state = UiState.Loading
            state.apply(titleTextView, progress, actionButton)

            actionButton.postDelayed({
                state = UiState.Success
                state.apply(titleTextView, progress, actionButton)
            }, 3000)
        }
    }
}