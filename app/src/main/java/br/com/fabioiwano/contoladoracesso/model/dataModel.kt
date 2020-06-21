package br.com.fabioiwano.contoladoracesso.model
import com.squareup.moshi.Json

data class credentialDataModel(
        @field:Json(name = "data") val data: String,
        @field:Json(name = "codigo") val codigo: String,
        @field:Json(name = "setor") val setor: String,
        @field:Json(name = "status") val status: String)

/*
 {
 "data" : "01/01/2020",
 "codigo" : "6176367167367131",
 "setor" : "Pista",
 "status" : "LIBERADO"
}
*/