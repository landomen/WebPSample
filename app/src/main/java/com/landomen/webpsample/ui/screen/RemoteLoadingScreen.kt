package com.landomen.webpsample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.landomen.webpsample.R
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RemoteLoadingScreen(modifier: Modifier = Modifier) {
    var imageLoadingLibrary by remember {
        mutableStateOf(ImageLoadingLibrary.NONE)
    }

    val zoomState = rememberZoomState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.remote_loading_screen_title),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { imageLoadingLibrary = ImageLoadingLibrary.COIL }) {
                Text(text = stringResource(id = R.string.remote_loading_button_load_coil))
            }

            Button(onClick = { imageLoadingLibrary = ImageLoadingLibrary.GLIDE }) {
                Text(text = stringResource(id = R.string.remote_loading_button_load_glide))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            when (imageLoadingLibrary) {
                ImageLoadingLibrary.NONE -> {}
                ImageLoadingLibrary.COIL -> {
                    AsyncImage(
                        model = "https://raw.githubusercontent.com/landomen/WebPSample/main/app/src/main/res/drawable/bg_beach_converted_80.webp",
                        contentDescription = "Coil image",
                        modifier = Modifier
                            .fillMaxSize()
                            .zoomable(zoomState)
                    )
                }

                ImageLoadingLibrary.GLIDE -> {
                    GlideImage(
                        model = "https://raw.githubusercontent.com/landomen/WebPSample/main/app/src/main/res/drawable/bg_beach_converted_80.webp",
                        contentDescription = "Glide image",
                        modifier = Modifier
                            .fillMaxSize()
                            .zoomable(zoomState)
                    )
                }
            }
        }
    }
}

private enum class ImageLoadingLibrary {
    NONE,
    COIL,
    GLIDE
}