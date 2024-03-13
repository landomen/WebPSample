package com.landomen.webpsample.data.jpg.source

import com.landomen.webpsample.R
import com.landomen.webpsample.data.jpg.model.JpgComparisonImage
import com.landomen.webpsample.data.jpg.model.JpgComparisonImageFormat

object JpgComparisonImagesProvider {

    /**
     * Provides a static map of comparison images mapped to different formats,
     * quality levels and file sizes.
     */
    val comparisonImages = mapOf(
        JpgComparisonImage.BEACH to mapOf(
            JpgComparisonImageFormat.JPG to mapOf(
                50f to (R.drawable.bg_beach_original_50 to 301),
                55f to (R.drawable.bg_beach_original_55 to 358),
                60f to (R.drawable.bg_beach_original_60 to 418),
                65f to (R.drawable.bg_beach_original_65 to 481),
                70f to (R.drawable.bg_beach_original_70 to 544),
                75f to (R.drawable.bg_beach_original_75 to 611),
                80f to (R.drawable.bg_beach_original_80 to 679),
                85f to (R.drawable.bg_beach_original_85 to 745),
                90f to (R.drawable.bg_beach_original_90 to 816),
                95f to (R.drawable.bg_beach_original_95 to 888),
                100f to (R.drawable.bg_beach_original_100 to 954)
            ),
            JpgComparisonImageFormat.WEBP to mapOf(
                50f to (R.drawable.bg_beach_converted_50 to 576),
                55f to (R.drawable.bg_beach_converted_55 to 611),
                60f to (R.drawable.bg_beach_converted_60 to 643),
                65f to (R.drawable.bg_beach_converted_65 to 679),
                70f to (R.drawable.bg_beach_converted_70 to 716),
                75f to (R.drawable.bg_beach_converted_75 to 754),
                80f to (R.drawable.bg_beach_converted_80 to 911),
                85f to (R.drawable.bg_beach_converted_85 to 1080),
                90f to (R.drawable.bg_beach_converted_90 to 1350),
                95f to (R.drawable.bg_beach_converted_95 to 1760),
                100f to (R.drawable.bg_beach_converted_100 to 5930)
            )
        ),
        JpgComparisonImage.CITY to mapOf(
            JpgComparisonImageFormat.JPG to mapOf(
                50f to (R.drawable.bg_city_original_50 to 179),
                55f to (R.drawable.bg_city_original_55 to 211),
                60f to (R.drawable.bg_city_original_60 to 247),
                65f to (R.drawable.bg_city_original_65 to 285),
                70f to (R.drawable.bg_city_original_70 to 325),
                75f to (R.drawable.bg_city_original_75 to 371),
                80f to (R.drawable.bg_city_original_80 to 417),
                85f to (R.drawable.bg_city_original_85 to 465),
                90f to (R.drawable.bg_city_original_90 to 514),
                95f to (R.drawable.bg_city_original_95 to 567),
                100f to (R.drawable.bg_city_original_100 to 611)
            ),
            JpgComparisonImageFormat.WEBP to mapOf(
                50f to (R.drawable.bg_city_converted_50 to 271),
                55f to (R.drawable.bg_city_converted_55 to 290),
                60f to (R.drawable.bg_city_converted_60 to 312),
                65f to (R.drawable.bg_city_converted_65 to 329),
                70f to (R.drawable.bg_city_converted_70 to 360),
                75f to (R.drawable.bg_city_converted_75 to 388),
                80f to (R.drawable.bg_city_converted_80 to 492),
                85f to (R.drawable.bg_city_converted_85 to 603),
                90f to (R.drawable.bg_city_converted_90 to 824),
                95f to (R.drawable.bg_city_converted_95 to 1170),
                100f to (R.drawable.bg_city_converted_100 to 3830)
            )
        ),
        JpgComparisonImage.MOUNTAINS to mapOf(
            JpgComparisonImageFormat.JPG to mapOf(
                50f to (R.drawable.bg_mountain_original_50 to 102),
                55f to (R.drawable.bg_mountain_original_55 to 121),
                60f to (R.drawable.bg_mountain_original_60 to 141),
                65f to (R.drawable.bg_mountain_original_65 to 162),
                70f to (R.drawable.bg_mountain_original_70 to 185),
                75f to (R.drawable.bg_mountain_original_75 to 210),
                80f to (R.drawable.bg_mountain_original_80 to 233),
                85f to (R.drawable.bg_mountain_original_85 to 257),
                90f to (R.drawable.bg_mountain_original_90 to 283),
                95f to (R.drawable.bg_mountain_original_95 to 309),
                100f to (R.drawable.bg_mountain_original_100 to 328)
            ),
            JpgComparisonImageFormat.WEBP to mapOf(
                50f to (R.drawable.bg_mountain_converted_50 to 131),
                55f to (R.drawable.bg_mountain_converted_55 to 141),
                60f to (R.drawable.bg_mountain_converted_60 to 152),
                65f to (R.drawable.bg_mountain_converted_65 to 163),
                70f to (R.drawable.bg_mountain_converted_70 to 174),
                75f to (R.drawable.bg_mountain_converted_75 to 189),
                80f to (R.drawable.bg_mountain_converted_80 to 233),
                85f to (R.drawable.bg_mountain_converted_85 to 294),
                90f to (R.drawable.bg_mountain_converted_90 to 391),
                95f to (R.drawable.bg_mountain_converted_95 to 577),
                100f to (R.drawable.bg_mountain_converted_100 to 775)
            )
        ),
        JpgComparisonImage.LAKE to mapOf(
            JpgComparisonImageFormat.JPG to mapOf(
                50f to (R.drawable.bg_lake_original_50 to 751),
                55f to (R.drawable.bg_lake_original_55 to 901),
                60f to (R.drawable.bg_lake_original_60 to 1060),
                65f to (R.drawable.bg_lake_original_65 to 1230),
                70f to (R.drawable.bg_lake_original_70 to 1410),
                75f to (R.drawable.bg_lake_original_75 to 1600),
                80f to (R.drawable.bg_lake_original_80 to 1790),
                85f to (R.drawable.bg_lake_original_85 to 1990),
                90f to (R.drawable.bg_lake_original_90 to 2190),
                95f to (R.drawable.bg_lake_original_95 to 2400),
                100f to (R.drawable.bg_lake_original_100 to 2590)
            ),
            JpgComparisonImageFormat.WEBP to mapOf(
                50f to (R.drawable.bg_lake_converted_50 to 1520),
                55f to (R.drawable.bg_lake_converted_55 to 1640),
                60f to (R.drawable.bg_lake_converted_60 to 1750),
                65f to (R.drawable.bg_lake_converted_65 to 1850),
                70f to (R.drawable.bg_lake_converted_70 to 1960),
                75f to (R.drawable.bg_lake_converted_75 to 2080),
                80f to (R.drawable.bg_lake_converted_80 to 2500),
                85f to (R.drawable.bg_lake_converted_85 to 3020),
                90f to (R.drawable.bg_lake_converted_90 to 3780),
                95f to (R.drawable.bg_lake_converted_95 to 5050),
                100f to (R.drawable.bg_lake_converted_100 to 15760)
            )
        ),
        JpgComparisonImage.PARTY to mapOf(
            JpgComparisonImageFormat.JPG to mapOf(
                50f to (R.drawable.bg_party_original_50 to 264),
                55f to (R.drawable.bg_party_original_55 to 309),
                60f to (R.drawable.bg_party_original_60 to 354),
                65f to (R.drawable.bg_party_original_65 to 403),
                70f to (R.drawable.bg_party_original_70 to 455),
                75f to (R.drawable.bg_party_original_75 to 508),
                80f to (R.drawable.bg_party_original_80 to 565),
                85f to (R.drawable.bg_party_original_85 to 620),
                90f to (R.drawable.bg_party_original_90 to 679),
                95f to (R.drawable.bg_party_original_95 to 738),
                100f to (R.drawable.bg_party_original_100 to 795)
            ),
            JpgComparisonImageFormat.WEBP to mapOf(
                50f to (R.drawable.bg_party_converted_50 to 309),
                55f to (R.drawable.bg_party_converted_55 to 330),
                60f to (R.drawable.bg_party_converted_60 to 360),
                65f to (R.drawable.bg_party_converted_65 to 381),
                70f to (R.drawable.bg_party_converted_70 to 421),
                75f to (R.drawable.bg_party_converted_75 to 447),
                80f to (R.drawable.bg_party_converted_80 to 552),
                85f to (R.drawable.bg_party_converted_85 to 725),
                90f to (R.drawable.bg_party_converted_90 to 962),
                95f to (R.drawable.bg_party_converted_95 to 1490),
                100f to (R.drawable.bg_party_converted_100 to 5160)
            )
        )
    )
}