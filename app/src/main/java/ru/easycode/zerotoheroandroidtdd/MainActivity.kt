package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var titleView: TextView
    private lateinit var removeButton: Button

    private var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleView = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)

        removeButton.setOnClickListener {
            state = State.Removed
            state.apply(rootLayout, titleView, removeButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as State
        state.apply(rootLayout, titleView, removeButton)
    }

    companion object {
        private const val KEY = "key"
    }
}

interface State : Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView, removeButton: Button)

    object Initial : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView, removeButton: Button) =
            Unit
    }

    object Removed : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView, removeButton: Button) {
            linearLayout.removeView(textView)
            removeButton.isEnabled = false
        }
    }
}