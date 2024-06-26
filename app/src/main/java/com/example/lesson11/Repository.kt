package com.example.myapp

import android.content.Context
import android.content.SharedPreferences

class Repository(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    private var localText: String? = null

    fun saveText(text: String) {
        localText = text
        sharedPreferences.edit().putString("saved_text", text).apply()
    }

    fun clearText() {
        localText = null
        sharedPreferences.edit().remove("saved_text").apply()
    }

    fun getText(): String {
        return localText ?: sharedPreferences.getString("saved_text", "") ?: ""
    }

    private fun getDataFromSharedPreference(): String? {
        return sharedPreferences.getString("saved_text", null)
    }

    private fun getDataFromLocalVariable(): String? {
        return localText
    }
}
