import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import components.RoundLabeledImageRow
import data.ImagesRepository
import network.KtorAppNetwork
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import screen.MainScreen
import viewmodel.AppViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App(
    viewModel: AppViewModel = viewModel {
        AppViewModel(
            ImagesRepository(KtorAppNetwork())
        )
    }
) {

    val labeledImages by viewModel.labeledImages.collectAsState()
    viewModel.getImages()


    MaterialTheme {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        Scaffold {
            MainScreen(labeledImages)
        }




    }
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()
