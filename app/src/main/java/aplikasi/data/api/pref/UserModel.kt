package aplikasi.data.api.pref

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val token : String,
    var isLogin: Boolean = false
) : Parcelable