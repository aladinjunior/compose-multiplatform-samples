package screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.size(15.dp))
        RoundLabeledImageRow(
            labeledImages = labeledImages,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.size(30.dp))
        Text(
            "More images",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 12.dp)
        )


        if (labeledImages.isNotEmpty()) {
            Column {
                RoundCornerImage(labeledImages.random())
                DynamicImageRow(labeledImages)
                RoundCornerImage(labeledImages.random())
            }

        }


    }
}