package components

import aladin.sample.library.resources.Res
import aladin.sample.library.resources.images_dark_theme
import aladin.sample.library.resources.images_light_theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Image(
                modifier = Modifier.size(60.dp),
                painter = if (!isSystemInDarkTheme()) painterResource(Res.drawable.images_dark_theme)
                else painterResource(Res.drawable.images_light_theme),
                contentDescription = null
            )

        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        },
        actions = {
            AppTopBarActionButton()
        }
    )

}

@Composable
fun AppTopBarActionButton() {
    val randomNumber = Random.nextInt(0, 999).toString()
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
    ) {
        Text(text = randomNumber, color = Color.White)
        Icon(
            imageVector = Icons.Outlined.ThumbUp,
            modifier = Modifier.padding(start = 4.dp),
            contentDescription = null,
            tint = Color.White
        )

    }
}