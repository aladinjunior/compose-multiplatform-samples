package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import domain.AppLabeledImage
import util.Constants.getFirstName


@Composable
fun RoundLabeledImageRow(
    labeledImages: List<AppLabeledImage>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
       items(labeledImages) { labeledImage ->
           RoundLabeledImage(imageUrl = labeledImage.imageUrl, authorName = labeledImage.authorName)
       }
    }
}

@Composable
fun RoundLabeledImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    authorName: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            error = {
                Text("Failed")
            },
            loading = {
                Text("Loading...")
            }
        )
        Text(
            text = authorName.getFirstName(),
            style = MaterialTheme.typography.bodySmall
        )
    }

}


