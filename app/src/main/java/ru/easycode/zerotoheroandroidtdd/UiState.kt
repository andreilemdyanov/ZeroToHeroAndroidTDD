package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import java.io.Serializable

interface UiState : Serializable {

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

    data class ShowData(private val text: String) : UiState {

        override fun apply(
            titleTextView: TextView,
            actionButton: Button,
            progressBar: ProgressBar
        ) {
            titleTextView.text = text
            titleTextView.isVisible = true
            actionButton.isEnabled = true
            progressBar.isVisible = false
        }
    }
}