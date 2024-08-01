package data

import network.AppNetworkDataSource

class ImagesRepository(
    private val dataSource: AppNetworkDataSource
) {

    suspend fun getImages() = dataSource.getImages()

}