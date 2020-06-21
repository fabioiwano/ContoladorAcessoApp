package br.com.fabioiwano.contoladoracesso
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val qrButton: Button = findViewById(R.id.qr_button)

        qrButton.setOnClickListener {
            callScannerActivity()
        }
    }

    private fun callScannerActivity() {
        startActivity(Intent(this, ScanActivity::class.java))
    }

    private fun qrApprove(){
        Toast.makeText(this, "Acesso autorizado", Toast.LENGTH_SHORT).show()
    }

    private fun qrReject(){
        Toast.makeText(this, "Acesso não autorizado", Toast.LENGTH_SHORT).show()
    }
}