package br.com.fabioiwano.contoladoracesso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ScanApprovedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_approved)
        val goBackButton: Button = findViewById(R.id.back_button)

        goBackButton.setOnClickListener {
           startActivity(Intent(this, ScanActivity::class.java))
           finish()
        }
    }

}