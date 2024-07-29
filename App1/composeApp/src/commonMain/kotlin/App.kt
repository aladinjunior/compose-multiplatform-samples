import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app1.composeapp.generated.resources.Res
import app1.composeapp.generated.resources.compose_multiplatform
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import components.RoundLabeledImage
import components.RoundLabeledImageRow
import okio.FileSystem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview




@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App(

) {

    val imageUrl = "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY"
    var currentPhrase by remember { mutableStateOf("") }

    MaterialTheme {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

//        SubcomposeAsyncImage(
//            modifier = Modifier
//                .size(250.dp)
//                .padding(16.dp),
//            model = "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY",
//            contentDescription = null,
//            error = {
//                Text("Falhou caralho")
//            },
//            loading = {
//                Text("Ta carregando")
//            }
//
//        )

//        RoundLabeledImage(imageUrl = imageUrl, authorName = "Aladinho")

//        RoundLabeledImageRow()



    }
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()
