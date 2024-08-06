package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import domain.AppLabeledImage
import util.Constants.RoundSmallerImageSize

@Composable
fun DynamicImageRow(
    labeledImages: List<AppLabeledImage>
) {

    val imagesWidth = RoundSmallerImageSize

    BoxWithConstraints {
        val displayedImages = calculateMaxImageDisplayed(imagesWidth, this)


        println("AMOUNT OF IMAGES: $displayedImages")



        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            labeledImages.shuffled().take(displayedImages).forEach {

                SmallerRoundCornerImage(it)
            }
        }


    }
}

@Composable
fun calculateMaxImageDisplayed(
    imagesWidth: Dp,
    constraint: BoxWithConstraintsScope
): Int {


//    val imagesWidth = 100.dp
    /**
     * get the max width of the screen
     */
    val currentScreenWidth = constraint.maxWidth
    /**
     * returns the quantity of images that can appear in the screen
     */
    return (currentScreenWidth / imagesWidth).toInt()

}