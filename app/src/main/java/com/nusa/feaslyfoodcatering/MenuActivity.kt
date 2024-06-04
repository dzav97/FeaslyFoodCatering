package com.nusa.feaslyfoodcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Handle button click to navigate to Paket 1
        val buttonNavigateBali: Button = findViewById(R.id.buttonNavigateBali)
        buttonNavigateBali.setOnClickListener {
            val intent = Intent(this, Paket3Activity::class.java)
            startActivity(intent)
        }

        // Handle button click to navigate to Paket 2
        val buttonNavigateUduk: Button = findViewById(R.id.buttonNavigateUduk)
        buttonNavigateUduk.setOnClickListener {
            val intent = Intent(this, Paket2Activity::class.java)
            startActivity(intent)
        }

        // Handle button click to navigate to Paket 3
        val buttonNavigateKuning: Button = findViewById(R.id.buttonNavigateKuning)
        buttonNavigateKuning.setOnClickListener {
            val intent = Intent(this, Paket3Activity::class.java)
            startActivity(intent)
        }
        val buttonNavigateProfileActivity: Button = findViewById(R.id.buttonProfile)
        buttonNavigateProfileActivity.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }
}
