package com.darker.ukl1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Backdoor : AppCompatActivity() {
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backdoor)

        text = findViewById(R.id.emailText)

        val email = intent.getStringExtra("String")
        if(email != null){
            text.text = email
        }
    }
}