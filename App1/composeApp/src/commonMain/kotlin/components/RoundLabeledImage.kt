package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import domain.AppLabeledImage


@Composable
fun RoundLabeledImageRow(
    labeledImages: List<AppLabeledImage>
) {
    LazyRow {
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            error = {
                Text("Falhou caralho")
            },
            loading = {
                Text("Ta carregando")
            }
        )
        Text(
            text = authorName,
            style = MaterialTheme.typography.subtitle1
        )
    }


}

