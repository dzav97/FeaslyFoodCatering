package com.nusa.feaslyfoodcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Paket3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paket3)
        // Mendapatkan referensi ke tombol checkout
        val btnCheckout: Button = findViewById(R.id.btnCheckout)

        // Menambahkan listener klik untuk tombol checkout
        btnCheckout.setOnClickListener {
            // Membuat intent untuk membuka activity_process
            val intent = Intent(this, ProcessActivity::class.java)

            // Memulai activity_process
            startActivity(intent)
        }
    }
}
