package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, decrementBtn: Button, incrementButton: Button)

    abstract class Abstract(private val text: String) : UiState {
        override fun apply(textView: TextView, decrementBtn: Button, incrementButton: Button) {
            textView.text = text
        }
    }

    data class Min(private val text: String) : Abstract(text) {
        override fun apply(textView: TextView, decrementBtn: Button, incrementButton: Button) {
            super.apply(textView, decrementBtn, incrementButton)
            decrementBtn.isEnabled = false
            incrementButton.isEnabled = true
        }
    }

    data class Base(private val text: String) : Abstract(text) {
        override fun apply(textView: TextView, decrementBtn: Button, incrementButton: Button) {
            super.apply(textView, decrementBtn, incrementButton)
            decrementBtn.isEnabled = true
            incrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : Abstract(text) {
        override fun apply(textView: TextView, decrementBtn: Button, incrementButton: Button) {
            super.apply(textView, decrementBtn, incrementButton)
            decrementBtn.isEnabled = true
            incrementButton.isEnabled = false
        }
    }
}
