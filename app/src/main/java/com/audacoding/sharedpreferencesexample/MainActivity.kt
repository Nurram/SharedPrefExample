package com.audacoding.sharedpreferencesexample

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        val pref = getSharedPreferences("myPref", MODE_PRIVATE)
//        pref.edit().remove("key").apply()

        val isLoggedIn = pref.getString("key", null)

        if(isLoggedIn != null) {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }

        btnLogin.setOnClickListener {
            if(etUsername.text.isNotEmpty() && etPassword.text.isNotEmpty()) {
                pref.edit().putString("key", etUsername.text.toString()).apply()

                val i = Intent(this, SecondActivity::class.java)
                startActivity(i)
            } else {
                Toast.makeText(
                        this,
                        "Silahkan isi field yang disediakan!",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }
}