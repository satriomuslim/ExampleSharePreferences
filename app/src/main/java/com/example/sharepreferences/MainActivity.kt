package com.example.sharepreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharepreferences.databinding.ActivityMainBinding
import com.example.sharepreferences.helper.Constant
import com.example.sharepreferences.helper.PreferencesHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharePref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePref = PreferencesHelper(this)

        binding.btnLogin.setOnClickListener {
            if (binding.username.text.isNotEmpty() && binding.password.text.isNotEmpty())
               saveSession(binding.username.text.toString(), binding.password.text.toString())
               showMessage("Berhasil Login")
               moveIntent()

        }

    }

    override fun onStart() {
        super.onStart()
        if(sharePref.getBoolean( Constant.PREF_IS_LOGIN))
            moveIntent()
    }

    private fun moveIntent(){
        startActivity(Intent(this, NextActivity::class.java))
        finish()
    }

    private fun saveSession(username: String, password: String) {
        sharePref.put(Constant.PREF_USERNAME, username)
        sharePref.put(Constant.PREF_PASSWORD, password)
        sharePref.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}