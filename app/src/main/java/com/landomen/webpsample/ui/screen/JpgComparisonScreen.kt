package com.landomen.webpsample.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.landomen.webpsample.R
import com.landomen.webpsample.data.jpg.model.JpgComparisonImage
import com.landomen.webpsample.data.jpg.model.JpgComparisonImageFormat
import com.landomen.webpsample.data.jpg.source.JpgComparisonImagesProvider
import com.landomen.webpsample.ui.widget.RadioButtonWithLabel
import net.engawapg.lib.zoomable.ZoomState
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable

private const val DEFAULT_IMAGE_QUALITY_PERCENTAGE = 75f

@Composable
internal fun JpgComparisonScreen(modifier: Modifier = Modifier) {
    var selectedPreviewImage by remember { mutableStateOf(JpgComparisonImage.BEACH) }
    var selectedPreviewImageFormat by remember {
        mutableStateOf(JpgComparisonImageFormat.JPG)
    }
    var imageQualityPercentage by remember {
        mutableFloatStateOf(DEFAULT_IMAGE_QUALITY_PERCENTAGE)
    }
    val zoomState = rememberZoomState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.jpg_screen_title),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(2.dp))

        ComparisonImageSelectorHeader(
            selectedPreviewImage = selectedPreviewImage,
            onPreviewImageSelect = { selectedPreviewImage = it },
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f)
        )

        ComparisonImage(
            selectedPreviewImage = selectedPreviewImage,
            selectedPreviewImageFormat = selectedPreviewImageFormat,
            imageQualityPercentage = imageQualityPercentage,
            zoomState = zoomState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        ImageAndFormatDetailsFooter(
            selectedPreviewImageFormat = selectedPreviewImageFormat,
            selectedPreviewImage = selectedPreviewImage,
            imageQualityPercentage = imageQualityPercentage,
            onFormatSelect = { selectedPreviewImageFormat = it },
            onQualityPercentageSelect = { imageQualityPercentage = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .zIndex(1f)
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun ComparisonImageSelectorHeader(
    selectedPreviewImage: JpgComparisonImage,
    onPreviewImageSelect: (JpgComparisonImage) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(JpgComparisonImagesProvider.comparisonImages.keys.size) { index ->
            val image = JpgComparisonImagesProvider.comparisonImages.keys.elementAt(index)

            RadioButtonWithLabel(
                titleRes = image.titleRes,
                selected = selectedPreviewImage == image,
                onClick = { onPreviewImageSelect(image) })
        }
    }
}

@Composable
private fun ComparisonImage(
    selectedPreviewImage: JpgComparisonImage,
    selectedPreviewImageFormat: JpgComparisonImageFormat,
    imageQualityPercentage: Float,
    zoomState: ZoomState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(
                id = JpgComparisonImagesProvider.comparisonImages[selectedPreviewImage]!![selectedPreviewImageFormat]!![imageQualityPercentage]!!.first
            ),
            contentDescription = "Image of ${selectedPreviewImage.name} in format $selectedPreviewImageFormat with quality setting $imageQualityPercentage%",
            modifier = Modifier
                .fillMaxSize()
                .zoomable(zoomState)
        )
    }
}

@Composable
private fun ImageAndFormatDetailsFooter(
    selectedPreviewImageFormat: JpgComparisonImageFormat,
    selectedPreviewImage: JpgComparisonImage,
    imageQualityPercentage: Float,
    onFormatSelect: (JpgComparisonImageFormat) -> Unit,
    onQualityPercentageSelect: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)) {
                Text(
                    text = stringResource(
                        R.string.jpg_format_selection_image_quality,
                        when (selectedPreviewImageFormat) {
                            JpgComparisonImageFormat.WEBP -> stringResource(id = R.string.general_format_webp)
                            JpgComparisonImageFormat.JPG -> stringResource(id = R.string.general_format_jpg)
                        },
                        imageQualityPercentage.toInt()
                    ),
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = stringResource(
                        id = R.string.jpg_format_selection_file_size,
                        JpgComparisonImagesProvider.comparisonImages[selectedPreviewImage]!![selectedPreviewImageFormat]!![imageQualityPercentage]!!.second
                    ),
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f)
                )
            }

            Slider(
                value = imageQualityPercentage,
                valueRange = 50f..100f,
                steps = 9,
                onValueChange = onQualityPercentageSelect
            )
        }

        FormatSelector(
            selectedPreviewImageFormat = selectedPreviewImageFormat,
            onFormatSelect = onFormatSelect,
        )

    }
}

@Composable
private fun FormatSelector(
    selectedPreviewImageFormat: JpgComparisonImageFormat,
    onFormatSelect: (JpgComparisonImageFormat) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
    ) {
        RadioButtonWithLabel(
            titleRes = R.string.jpg_format_selection_jpg,
            selected = selectedPreviewImageFormat == JpgComparisonImageFormat.JPG,
            onClick = {
                onFormatSelect(JpgComparisonImageFormat.JPG)
            }
        )

        RadioButtonWithLabel(
            titleRes = R.string.jpg_format_selection_webp,
            selected = selectedPreviewImageFormat == JpgComparisonImageFormat.WEBP,
            onClick = {
                onFormatSelect(JpgComparisonImageFormat.WEBP)
            }
        )
    }
}

@Preview
@Composable
private fun JpgComparisonScreenPreview() {
    Surface {
        JpgComparisonScreen()
    }
}