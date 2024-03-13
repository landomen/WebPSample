package com.landomen.webpsample.data.png.source

import com.landomen.webpsample.R
import com.landomen.webpsample.data.png.model.PngComparisonImage
import com.landomen.webpsample.data.png.model.PngComparisonImageTriple

object PngComparisonImagesProvider {

    val comparisonImages = listOf(
        PngComparisonImageTriple(
            PngComparisonImage.PngImage(
                drawableId = R.drawable.ic_dashboard,
                contentDescription = "PNG Dashboard",
                sizeKB = 15.21f
            ),
            PngComparisonImage.WebPImageLossless(
                drawableId = R.drawable.ic_dashboard_converted,
                contentDescription = "WebP Dashboard Lossless",
                sizeKB = 7.06f
            ),
            PngComparisonImage.WebPImageLossy(
                drawableId = R.drawable.ic_dashboard_converted_80,
                contentDescription = "WebP Dashboard 80%",
                sizeKB = 7.66f
            )
        ),
        PngComparisonImageTriple(
            PngComparisonImage.PngImage(
                drawableId = R.drawable.ic_laptop,
                contentDescription = "PNG Laptop",
                sizeKB = 64.46f
            ),
            PngComparisonImage.WebPImageLossless(
                drawableId = R.drawable.ic_laptop_converted,
                contentDescription = "WebP Laptop Lossless",
                sizeKB = 22.5f
            ),
            PngComparisonImage.WebPImageLossy(
                drawableId = R.drawable.ic_laptop_converted_80,
                contentDescription = "WebP Laptop 80%",
                sizeKB = 17.48f
            )
        ),
        PngComparisonImageTriple(
            PngComparisonImage.PngImage(
                drawableId = R.drawable.ic_tree,
                contentDescription = "PNG Tree",
                sizeKB = 26.59f
            ),
            PngComparisonImage.WebPImageLossless(
                drawableId = R.drawable.ic_tree_converted,
                contentDescription = "WebP Tree Lossless",
                sizeKB = 11.07f
            ),
            PngComparisonImage.WebPImageLossy(
                drawableId = R.drawable.ic_tree_converted_80,
                contentDescription = "WebP Tree 80%",
                sizeKB = 11.2f
            )
        )
    )
}