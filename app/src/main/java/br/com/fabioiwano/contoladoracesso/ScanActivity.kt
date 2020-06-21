package br.com.fabioiwano.contoladoracesso
import android.Manifest
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Toast
import br.com.fabioiwano.contoladoracesso.api.api
import br.com.fabioiwano.contoladoracesso.model.credentialDataModel
import br.com.fabioiwano.contoladoracesso.utils.BASE_URL
import com.google.zxing.Result
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_scan.*
import kotlinx.coroutines.delay
import me.dm7.barcodescanner.zxing.ZXingScannerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private var customerEndPoint: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        //Checar e setar permissao da camera

        Dexter.withActivity(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object:PermissionListener{
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    z_xing_scanner.setResultHandler(this@ScanActivity)
                    z_xing_scanner.startCamera()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    Toast.makeText(this@ScanActivity,"Para utilizar o leitor, permita o uso da câmera em seu App",Toast.LENGTH_SHORT).show()
                }
            }).check()

    }

    override fun handleResult(rawResult: Result?) {


        customerEndPoint = rawResult!!.toString()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val postsApi = retrofit.create(api::class.java)
        val response = postsApi.getAllPosts(customerEndPoint)

        response.enqueue(object:Callback<credentialDataModel>{
            override fun onFailure(call: Call<credentialDataModel>, t: Throwable) {
                    //
            }

            override fun onResponse(call: Call<credentialDataModel>, response: Response<credentialDataModel>) {

                val usersData = response.body()
                val approvedStatus = usersData!!.status!!.toString()

                when (approvedStatus) {
                    "LIBERADO" -> approvedFeedback()
                    "BLOQUEADO" -> deniedFeedback()
                }
            }
        })
    }

    private fun approvedFeedback(){
        startActivity(Intent(this, ScanApprovedActivity::class.java))
        finish()
    }

    private fun deniedFeedback(){
        startActivity(Intent(this, ScanDeniedActivity::class.java))
        finish()
    }

}

