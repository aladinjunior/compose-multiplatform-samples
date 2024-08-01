package domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppLabeledImage(
    @SerialName("download_url")
    val imageUrl: String,
    @SerialName("author")
    val authorName: String,
)