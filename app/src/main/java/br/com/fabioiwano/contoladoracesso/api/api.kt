package br.com.fabioiwano.contoladoracesso.api
import br.com.fabioiwano.contoladoracesso.model.credentialDataModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


interface api {
        @GET("/v3/{customerCodeString}")
        fun getAllPosts(@Path("customerCodeString") customerCodeString: String): Call<credentialDataModel>
}