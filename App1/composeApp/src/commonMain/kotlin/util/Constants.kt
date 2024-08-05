package util

import androidx.compose.ui.unit.dp

object Constants {

    val RoundSmallerImageSize = 180.dp

    fun String.getFirstName() : String  = this.split(" ")[0]

}