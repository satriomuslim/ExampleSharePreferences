package com.example.sharepreferences.helper

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper (context: Context) {

    private val PREF_NAME = "sharepref123"
    private var sharepref: SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharepref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharepref.edit()
    }

    fun put(key: String, value: String?){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key: String) : String? {
        return sharepref.getString(key, null )
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String) : Boolean {
        return sharepref.getBoolean(key, false )
    }

    fun clear() {
        editor.clear()
            .apply()
    }



}