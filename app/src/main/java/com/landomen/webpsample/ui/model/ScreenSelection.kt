package com.landomen.webpsample.ui.model

import androidx.annotation.StringRes
import com.landomen.webpsample.R

enum class ScreenSelection(@StringRes val titleRes: Int) {
    PNG_VS_WEBP(R.string.intro_png_vs_webp),
    JPG_VS_WEBP(R.string.intro_jpg_vs_webp),
    REMOTE_LOADING(R.string.intro_remote_loading),
    BENCHMARK(R.string.intro_benchmark)
}