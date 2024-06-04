package com.nusa.feaslyfoodcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Mendapatkan referensi ke EditText untuk username dan email
        usernameEditText = findViewById(R.id.username)
        emailEditText = findViewById(R.id.email)


        // Mendapatkan referensi ke tombol Save
        val buttonSave: Button = findViewById(R.id.buttonSave)

        // Menambahkan listener klik untuk tombol Save
        buttonSave.setOnClickListener {
            // Memeriksa apakah username dan email sudah diisi
            val username = usernameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()

            if (username.isNotEmpty() && email.isNotEmpty() && email.contains("@")) {
                // Implementasi simpan data atau operasi yang sesuai di sini
                // Misalnya, simpan data ke database atau melakukan operasi lain

                // Setelah operasi selesai, kembali ke com.nusa.feaslyfoodcatering.MenuActivity
                val intent = Intent(this, MenuActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            } else {
                // Jika username, email kosong, atau email tidak mengandung @, tampilkan pesan kesalahan
                if (username.isEmpty()) {
                    usernameEditText.error = "Username harus diisi"
                }
                if (email.isEmpty()) {
                    emailEditText.error = "Email harus diisi"
                }
                if (!email.contains("@")) {
                    emailEditText.error = "Email harus valid (jangan boong!)"
                }
            }
        }

        // Mendapatkan referensi ke tombol Cancel
        val buttonCancel: Button = findViewById(R.id.buttonCancel)

        // Menambahkan listener klik untuk tombol Cancel
        buttonCancel.setOnClickListener {
            // Kembali ke com.nusa.feaslyfoodcatering.MenuActivity tanpa melakukan operasi apa pun
            val intent = Intent(this, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
