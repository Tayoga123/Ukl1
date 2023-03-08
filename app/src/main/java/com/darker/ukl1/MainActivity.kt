package com.darker.ukl1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var edtEmail: EditText
    lateinit var edtPass: EditText
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.email)
        edtPass = findViewById(R.id.password)
        btnLogin = findViewById(R.id.login)

        btnLogin.setOnClickListener(this)
    }

    fun isEmailValid(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onClick(p0: View?) {
        var isEmptyEmail: Boolean = false
        var isEmail: Boolean = false
        var isEmptyPass: Boolean = false

        if (edtEmail.text.toString().trim().length == 0) {
            edtEmail.error = "Email cannot be empty"
            isEmptyEmail = true
        } else if (isEmailValid(edtEmail.text) == false) {
            edtEmail.error = "Email is not Valid"
            isEmail = true
        }

        if (edtPass.text.toString().trim().length == 0) {
            edtPass.error = "Password cannot be empty"
            isEmptyPass = true
        }
        if (!isEmptyEmail && !isEmail && !isEmptyPass) {
            val moveIntent = Intent(this@MainActivity, Backdoor::class.java)
            val email = edtEmail.text.toString()
            moveIntent.putExtra("String", email)
            startActivity(moveIntent)
        }
    }
}