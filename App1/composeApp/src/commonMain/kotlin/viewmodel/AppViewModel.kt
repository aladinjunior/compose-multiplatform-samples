package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.ImagesRepository
import domain.AppLabeledImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


/**
 * [AppViewModel] handle with images data.
 */

class AppViewModel(
    private val imagesRepository: ImagesRepository
) : ViewModel() {

    private val _labeledImages = MutableStateFlow(listOf<AppLabeledImage>())
    val labeledImages = _labeledImages.asStateFlow()


    fun getImages() = viewModelScope.launch {

        _labeledImages.value = imagesRepository.getImages()

    }

}