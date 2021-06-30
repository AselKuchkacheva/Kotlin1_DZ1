package com.example.kotlin1_dz1.utils

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, msg: String) {
    val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
    toast.show()
}