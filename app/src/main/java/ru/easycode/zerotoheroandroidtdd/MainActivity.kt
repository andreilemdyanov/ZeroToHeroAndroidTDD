package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            addTextView(binding.inputEditText.text.toString())
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val list = binding.contentLayout.children.map { (it as TextView).text.toString() }.toList()
        outState.putStringArrayList(KEY, ArrayList(list))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList(KEY) ?: ArrayList()
        list.forEach { addTextView(it) }

    }

    private fun addTextView(inputText: String) {
        binding.contentLayout.addView(
            TextView(this).apply {
                text = inputText
            })
    }

    companion object {
        const val KEY = "Key"
    }
}