package aplikasi.data.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("umkm")
    fun getUmkmHome() : ResponseUmkmHome


    @FormUrlEncoded
    @POST("auth/api/v1/register")
    suspend fun register(
        @Field("id_provinsi") id_provinsi: Int,
        @Field("nik") nik: String,
        @Field("nama_lengkap") nama_lengkap: String,
        @Field("tgl_lahir") tgl_lahir: String,
        @Field("no_hp") no_hp: String,
        @Field("alamat") alamat: String,
        @Field("email") email: String,
        @Field("password") password: String,

        ) : ResponseRegister

    @FormUrlEncoded
    @POST("auth/api/v1/login")
    suspend fun login(
        @Field("email") email : String,
        @Field("password") password : String
    ) : ResponseLogin?
}