package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.TEXT_ALIGNMENT_CENTER
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootLayout = LinearLayout(this)
            .apply {
                id = R.id.rootLayout
                orientation = VERTICAL
                gravity = TEXT_ALIGNMENT_CENTER
            }
        textView = TextView(this)
            .apply {
                id = R.id.titleTextView
                text = "Hello World!"
            }
        val removeBtn = Button(this)
            .apply {
                id = R.id.removeButton
                text = "remove"
            }

        rootLayout.addView(textView)
        rootLayout.addView(removeBtn)
        setContentView(rootLayout)


        removeBtn.setOnClickListener {
            rootLayout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_TEXT, !rootLayout.children.contains(textView))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(STATE_TEXT))
            rootLayout.removeView(textView)
    }

    companion object {
        private const val STATE_TEXT = "state_text"
    }
}