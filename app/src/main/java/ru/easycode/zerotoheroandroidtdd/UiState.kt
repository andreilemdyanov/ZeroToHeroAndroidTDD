package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {

    fun apply(titleTextView: TextView, progress: ProgressBar, actionButton: Button) = Unit

    object Initial : UiState {
        override fun apply(titleTextView: TextView, progress: ProgressBar, actionButton: Button) {
            titleTextView.isVisible = false
            progress.isVisible = false
            actionButton.isEnabled = true
        }
    }

    object Loading : UiState {
        override fun apply(titleTextView: TextView, progress: ProgressBar, actionButton: Button) {
            actionButton.isEnabled = false
            progress.isVisible = true
            titleTextView.isVisible = false
        }
    }

    object Success : UiState {
        override fun apply(titleTextView: TextView, progress: ProgressBar, actionButton: Button) {
            titleTextView.isVisible = true
            progress.isVisible = false
            actionButton.isEnabled = true
        }
    }
}