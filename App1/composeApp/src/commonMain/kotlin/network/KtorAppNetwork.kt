package network

import domain.AppLabeledImage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.random.Random

class KtorAppNetwork : AppNetworkDataSource {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    /**
     * [getImages] fetches the images from api, generating a random number from 0 to 34
     * to specify the API page's number
     */
    override suspend fun getImages(): List<AppLabeledImage> {
        val randomPage = Random.nextInt(0, 34)
        return httpClient.get("https://picsum.photos/v2/list?page=$randomPage").body()
    }
}