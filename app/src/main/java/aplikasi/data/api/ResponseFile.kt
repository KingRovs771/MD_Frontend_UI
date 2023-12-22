package aplikasi.data.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseUmkmHome(

	@field:SerializedName("values")
	val values: List<UmkmData?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class UmkmData(

	@field:SerializedName("trgt_invest")
	val trgtInvest: Int? = null,

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("tgl_berakhir")
	val tglBerakhir: String? = null,

	@field:SerializedName("id_sektor")
	val idSektor: Int? = null,

	@field:SerializedName("invest_amount")
	val investAmount: Int? = null,

	@field:SerializedName("id_umkm")
	val idUmkm: Int? = null,

	@field:SerializedName("nama_umkm")
	val namaUmkm: String? = null,

	@field:SerializedName("nama_sektor")
	val namaSektor: String? = null,

	@field:SerializedName("id_user")
	val idUser: Int? = null,

	@field:SerializedName("id_provinsi")
	val idProvinsi: Int? = null
)

data class ResponseLogin(

	@field:SerializedName("expires")
	val expires: Int? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("currUser")
	val currUser: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)

data class ResponseRegister(

	@field:SerializedName("values")
	val values: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)






