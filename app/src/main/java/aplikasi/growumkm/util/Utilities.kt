package aplikasi.growumkm.util

import java.text.NumberFormat


fun getRupiahFormat(number: Int): String {
    val data = number.toDouble()
    return "Rp. ${NumberFormat.getInstance().format(data)}"
}