package screen


import aladin.sample.library.resources.Res
import aladin.sample.library.resources.more_images
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.DynamicImageRow
import components.RoundCornerImage

import components.RoundLabeledImageRow
import domain.AppLabeledImage
import io.ktor.util.network.NetworkAddress
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    labeledImages: List<AppLabeledImage>
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround
    ) {
        RoundLabeledImageRow(labeledImages)
        Text(stringResource(Res.string.more_images))
        if (labeledImages.isNotEmpty()) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                RoundCornerImage(labeledImages.last())
                DynamicImageRow(labeledImages)
                RoundCornerImage(labeledImages.first())
//                RoundCornerImage(labeledImages.first())
//                RoundCornerImage(labeledImages.first())
//                RoundCornerImage(labeledImages.first())
//                RoundCornerImage(labeledImages.first())
            }

        }




    }
}