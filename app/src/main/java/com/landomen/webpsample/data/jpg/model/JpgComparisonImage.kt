package com.landomen.webpsample.data.jpg.model

import androidx.annotation.StringRes
import com.landomen.webpsample.R

enum class JpgComparisonImage(@StringRes val titleRes: Int) {
    BEACH(R.string.jpg_image_beach),
    CITY(R.string.jpg_image_city),
    MOUNTAINS(R.string.jpg_image_mountains),
    LAKE(R.string.jpg_image_lake),
    PARTY(R.string.jpg_image_party),
}