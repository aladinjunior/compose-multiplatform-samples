package viewmodel

import androidx.lifecycle.ViewModel
import components.RoundLabeledImage
import data.ImagesRepository
import domain.AppLabeledImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


/**
 * [AppViewModel] handle with images data.
 */

class AppViewModel(
    private val imagesRepository: ImagesRepository
) : ViewModel() {

    private val _labeledImages = MutableStateFlow(listOf<AppLabeledImage>())
    val labeledImage = _labeledImages.asStateFlow()


    fun fetchImagesData() {

    }
}