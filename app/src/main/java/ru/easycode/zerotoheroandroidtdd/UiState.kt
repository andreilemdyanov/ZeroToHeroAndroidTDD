package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {

    fun apply(titleTextView: TextView, actionButton: Button, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(
            titleTextView: TextView,
            actionButton: Button,
            progressBar: ProgressBar
        ) {
            titleTextView.isVisible = false
            actionButton.isEnabled = false
            progressBar.isVisible = true
        }
    }

    object ShowData : UiState {
        override fun apply(
            titleTextView: TextView,
            actionButton: Button,
            progressBar: ProgressBar
        ) {
            titleTextView.isVisible = true
            actionButton.isEnabled = true
            progressBar.isVisible = false
        }
    }
}