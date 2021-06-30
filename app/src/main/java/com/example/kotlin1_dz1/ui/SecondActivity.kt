package com.example.kotlin1_dz1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1_dz1.R
import com.example.kotlin1_dz1.utils.TEXT_KEY
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        checkIntent()
        setupListener()
    }

    private fun setupListener() {

        btn_sent_activity_second.setOnClickListener {
            if (!et_text_activity_second.text.isNullOrEmpty())
                send()
        }

    }

    private fun send() {

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TEXT_KEY, et_text_activity_second.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()

    }

    private fun checkIntent() {

        val text: String? = intent.getStringExtra(TEXT_KEY)
        et_text_activity_second.setText(text)
    }

}