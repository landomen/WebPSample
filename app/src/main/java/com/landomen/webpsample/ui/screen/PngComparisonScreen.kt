package com.landomen.webpsample.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.landomen.webpsample.R
import com.landomen.webpsample.data.png.model.PngComparisonImage
import com.landomen.webpsample.data.png.source.PngComparisonImagesProvider.comparisonImages
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable

@Composable
internal fun PngComparisonScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.png_screen_title),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Header()

        Spacer(modifier = Modifier.height(32.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(comparisonImages.size) { index ->
                val (pngImage, webPImageLossless, webPImageLossy) = comparisonImages[index]
                ImageComparisonRow(
                    pngImage = pngImage,
                    webPImageLossless = webPImageLossless,
                    webPImageLossy = webPImageLossy
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        ColumnTitle(
            title = stringResource(id = R.string.general_format_png),
            subtitle = stringResource(id = R.string.png_column_png_subtitle),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ColumnTitle(
            title = stringResource(id = R.string.general_format_webp),
            subtitle = stringResource(id = R.string.png_column_webp_lossless_subtitle),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ColumnTitle(
            title = stringResource(id = R.string.general_format_webp),
            subtitle = stringResource(id = R.string.png_column_webp_lossy_subtitle),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ColumnTitle(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun ImageComparisonRow(
    pngImage: PngComparisonImage.PngImage,
    webPImageLossless: PngComparisonImage.WebPImageLossless,
    webPImageLossy: PngComparisonImage.WebPImageLossy,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ) {
        SingleComparisonImage(image = pngImage, modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.width(16.dp))

        SingleComparisonImage(image = webPImageLossless, modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.width(16.dp))

        SingleComparisonImage(image = webPImageLossy, modifier = Modifier.weight(1f))
    }
}

@Composable
private fun SingleComparisonImage(
    image: PngComparisonImage,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image.drawableId),
            contentDescription = image.contentDescription,
            modifier = Modifier.zoomable(rememberZoomState())
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = R.string.general_file_size, image.sizeKB),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun PngComparisonScreenPreview() {
    Surface {
        PngComparisonScreen()
    }
}