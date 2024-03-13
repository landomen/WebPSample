package com.landomen.webpsample.data.png.model

data class PngComparisonImageTriple(
    val pngImage: PngComparisonImage.PngImage,
    val webPImageLossless: PngComparisonImage.WebPImageLossless,
    val webPImageLossy: PngComparisonImage.WebPImageLossy
)