package com.example.kotlin1_dz1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1_dz1.R
import com.example.kotlin1_dz1.utils.TEXT_KEY
import com.example.kotlin1_dz1.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForResult()
        setupListener()
    }

    private fun setupListener() {

        btn_sent_activity_main.setOnClickListener {
            if (!et_text_activity_main.text.isNullOrEmpty()) send()
            else showToast(this, getString(R.string.err_null))
        }

    }

    private fun send() {

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(TEXT_KEY, et_text_activity_main.text.toString())
        resultLauncher.launch(intent)

    }

    private fun registerForResult() {

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK)
                    checkData(result.data)
            }

    }

    private fun checkData(data: Intent?) {

        if (data != null) {
            et_text_activity_main.setText(data.getStringExtra(TEXT_KEY))
        }

    }
}