package com.example.technicaltest_gli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameET: EditText
    private lateinit var passwordET: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        usernameET = findViewById(R.id.usernameField)
        passwordET = findViewById(R.id.passwordField)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val username = usernameET.text.toString()
        val password = passwordET.text.toString()

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
        }
        else if (username == "alfagift-admin" && password == "asdf") {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}