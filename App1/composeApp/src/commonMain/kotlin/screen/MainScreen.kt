package screen


import aladin.sample.library.resources.Res
import aladin.sample.library.resources.more_images
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.AppTopBar
import components.DynamicImageRow
import components.RoundCornerImage

import components.RoundLabeledImageRow
import domain.AppLabeledImage


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    labeledImages: List<AppLabeledImage>
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.verticalScroll(rememberScrollState())

    ) {
//        AppTopBar()
//        Spacer(Modifier.size(8.dp))
        RoundLabeledImageRow(
            labeledImages = labeledImages,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))

        Text(
            "More images",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        if (labeledImages.isNotEmpty()) {
            Column(

            ) {
                RoundCornerImage(labeledImages.last())
                DynamicImageRow(labeledImages)
                RoundCornerImage(labeledImages.first())

            }

        }


    }
}