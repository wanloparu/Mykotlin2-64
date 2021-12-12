package com.example.mykotlin

import android.content.Context
import android.widget.Toast


fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun String.covertToBath(): String{
    return "$this Bath"
}