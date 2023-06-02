package com.example.sharepreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharepreferences.databinding.ActivityNextBinding
import com.example.sharepreferences.helper.Constant
import com.example.sharepreferences.helper.PreferencesHelper

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    private lateinit var sharePref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePref = PreferencesHelper(this)

        binding.textUsername.text = sharePref.getString(Constant.PREF_USERNAME)

        binding.btnLogout.setOnClickListener {
            sharePref.clear()
            showMessage("Berhasil Logout")
            moveIntent()
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}