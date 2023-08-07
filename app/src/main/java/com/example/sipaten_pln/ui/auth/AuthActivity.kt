package com.example.sipaten_pln.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sipaten_pln.R
import com.example.sipaten_pln.ui.auth.signin.SigninFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (savedInstanceState == null) {
            // Tambahkan SigninFragment hanya jika belum ditambahkan untuk mencegah duplikasi
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentSignin, SigninFragment())
                .commit()
        }
    }
}
