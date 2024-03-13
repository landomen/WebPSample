package com.landomen.webpsample.data.png.model

import androidx.annotation.DrawableRes

sealed interface PngComparisonImage {
    val drawableId: Int
    val contentDescription: String
    val sizeKB: Float

    data class PngImage(
        @DrawableRes override val drawableId: Int,
        override val contentDescription: String,
        override val sizeKB: Float
    ) : PngComparisonImage

    data class WebPImageLossless(
        @DrawableRes override val drawableId: Int,
        override val contentDescription: String,
        override val sizeKB: Float
    ) : PngComparisonImage

    data class WebPImageLossy(
        @DrawableRes override val drawableId: Int,
        override val contentDescription: String,
        override val sizeKB: Float
    ) : PngComparisonImage
}
