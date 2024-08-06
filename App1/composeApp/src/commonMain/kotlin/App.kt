import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import data.ImagesRepository
import network.KtorAppNetwork
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import components.AppTopBar
import screen.MainScreen
import ui.theme.AppTheme
import viewmodel.AppViewModel


@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
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
    val scrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())


    AppTheme {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                AppTopBar()
            }
        )
        { paddingValues ->

            MainScreen(
                modifier = Modifier.padding(paddingValues),
                labeledImages = labeledImages
            )

        }


    }
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()
