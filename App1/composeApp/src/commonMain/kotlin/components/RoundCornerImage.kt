package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import domain.AppLabeledImage
import util.Constants.RoundSmallerImageSize

@Composable
fun RoundCornerImage(
    labeledImage: AppLabeledImage
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        shape = RoundedCornerShape(30.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            SubcomposeAsyncImage(
                model = labeledImage.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = {
                    Text("Failed to load images :(")
                },
                loading = {
                    Text("Loading...")
                }
            )
            Button(
                modifier = Modifier.align(Alignment.TopEnd).padding(12.dp),
                onClick = {},
                border = BorderStroke(width = 1.dp, color = Color.White),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "follow this author",
                    color = Color.White
                )


            }
            Text(
                modifier = Modifier.align(Alignment.BottomStart).padding(12.dp),
                text = labeledImage.authorName,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )

        }

    }
}

@Composable
fun SmallerRoundCornerImage(
    labeledImage: AppLabeledImage
) {
    Card(
        modifier = Modifier.size(RoundSmallerImageSize),
        shape = RoundedCornerShape(30.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            SubcomposeAsyncImage(
                model = labeledImage.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = {
                    Text("Failed to load images :(")
                },
                loading = {
                    Text("Loading...")
                }
            )
            Text(
                modifier = Modifier.align(Alignment.BottomStart).padding(12.dp),
                text = labeledImage.authorName,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )

        }

    }
}
