package network

import domain.AppLabeledImage

interface AppNetworkDataSource {

    suspend fun getImages() : List<AppLabeledImage>

}