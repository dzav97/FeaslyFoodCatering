package com.nusa.feaslyfoodcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)

        // Mendapatkan referensi ke tombol Home
        val btnHome: Button = findViewById(R.id.btnHome)

        // Menambahkan listener klik untuk tombol Home
        btnHome.setOnClickListener {
            // Membuat intent untuk kembali ke com.nusa.feaslyfoodcatering.MenuActivity
            val intent = Intent(this, MenuActivity::class.java)
            // Membersihkan stack activity sehingga com.nusa.feaslyfoodcatering.MenuActivity menjadi activity teratas
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            // Finish activity_process sehingga tidak dapat kembali ke sini dari tombol back
            finish()
        }
    }
}
