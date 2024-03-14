package com.landomen.webpsample.ui.screen

import android.widget.Toast
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.EqualityDelegate
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.landomen.webpsample.R
import com.landomen.webpsample.data.jpg.model.JpgComparisonImageFormat
import com.landomen.webpsample.ui.widget.RadioButtonWithLabel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val MAX_BENCHMARK_RUNS = 100
private var benchmarkRunTimes = mutableListOf<Int>()
private var runStartTimestamp = 0

@Composable
internal fun BenchmarkScreen(modifier: Modifier = Modifier) {
    var selectedImageFormat by remember {
        mutableStateOf(JpgComparisonImageFormat.JPG)
    }
    var benchmarkState by remember {
        mutableStateOf<BenchmarkState>(BenchmarkState.Idle)
    }

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {

        Text(
            text = stringResource(id = R.string.benchmark_screen_title),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        SelectableFormatRow(
            selectedOption = selectedImageFormat,
            enabled = benchmarkState !is BenchmarkState.Running,
            onOptionSelect = {
                selectedImageFormat = it
            }
        )

        Button(
            enabled = benchmarkState !is BenchmarkState.Running,
            onClick = {
                benchmarkRunTimes = mutableListOf()
                benchmarkState = BenchmarkState.Running(1)
            }) {
            Text(text = stringResource(id = R.string.benchmark_button_start))
        }

        Spacer(modifier = Modifier.height(8.dp))

        when (benchmarkState) {
            is BenchmarkState.Running -> {
                RunningContent(
                    state = benchmarkState as BenchmarkState.Running,
                    selectedImageFormat = selectedImageFormat,
                    onLoadingStart = {
                        runStartTimestamp = System.currentTimeMillis().toInt()
                    },
                    onLoadingFinish = {
                        benchmarkRunTimes.add(
                            System.currentTimeMillis().toInt() - runStartTimestamp
                        )

                        val state = benchmarkState as BenchmarkState.Running
                        if (state.runCount >= MAX_BENCHMARK_RUNS) {
                            benchmarkState = BenchmarkState.Finished(
                                benchmarkRunTimes.average().toInt(),
                                benchmarkRunTimes.minOrNull() ?: 0,
                                benchmarkRunTimes.maxOrNull() ?: 0
                            )
                        } else {
                            coroutineScope.launch {
                                // need to use delay to display the image for a bit
                                delay(100)
                                benchmarkState = BenchmarkState.Running(state.runCount + 1)
                            }
                        }
                    },
                    onLoadingError = {
                        it.printStackTrace()
                        benchmarkState = BenchmarkState.Idle
                        Toast.makeText(
                            context,
                            "Error running benchmark!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }

            is BenchmarkState.Finished -> {
                ResultContent(benchmarkState as BenchmarkState.Finished)
            }

            else -> {
                Box(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun RunningContent(
    state: BenchmarkState.Running,
    selectedImageFormat: JpgComparisonImageFormat,
    onLoadingStart: () -> Unit,
    onLoadingFinish: () -> Unit,
    onLoadingError: (Throwable) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {

        Text(
            text = stringResource(
                id = R.string.benchmark_run_count,
                state.runCount
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(
                        when (selectedImageFormat) {
                            JpgComparisonImageFormat.JPG -> R.drawable.bg_beach_original_100
                            JpgComparisonImageFormat.WEBP -> R.drawable.bg_beach_converted_80
                        }
                    )
                    .size(Size.ORIGINAL)
                    .diskCachePolicy(CachePolicy.DISABLED)
                    .memoryCachePolicy(CachePolicy.DISABLED)
                    .listener(
                        onStart = { _ ->
                            onLoadingStart()
                        },
                        onSuccess = { _, _ ->
                            onLoadingFinish()
                        },
                        onError = { _, throwable ->
                            onLoadingError(throwable.throwable)
                        })
                    .build(),
                contentDescription = null,
                // to trigger re-loading when benchmarkRunCount changes
                modelEqualityDelegate = object : EqualityDelegate {
                    override fun equals(self: Any?, other: Any?): Boolean {
                        return false
                    }

                    override fun hashCode(self: Any?): Int {
                        return state.runCount
                    }

                },
                modifier = Modifier.fillMaxSize()
            )

            CircularProgressIndicator()
        }
    }
}

@Composable
private fun ResultContent(
    state: BenchmarkState.Finished,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        ResultText(text = stringResource(R.string.benchmark_result))

        Spacer(modifier = Modifier.height(16.dp))

        ResultText(
            text = stringResource(
                id = R.string.benchmark_result_average,
                state.averageTime
            )
        )

        Spacer(modifier = Modifier.height(2.dp))

        ResultText(
            text = stringResource(
                id = R.string.benchmark_result_min,
                state.minTime
            )
        )

        Spacer(modifier = Modifier.height(2.dp))

        ResultText(
            text = stringResource(
                id = R.string.benchmark_result_max,
                state.maxTime
            )
        )
    }
}

@Composable
private fun ResultText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
private fun SelectableFormatRow(
    selectedOption: JpgComparisonImageFormat,
    enabled: Boolean,
    onOptionSelect: (JpgComparisonImageFormat) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        RadioButtonWithLabel(
            titleRes = R.string.general_format_jpg,
            selected = selectedOption == JpgComparisonImageFormat.JPG,
            enabled = enabled,
            onClick = { onOptionSelect(JpgComparisonImageFormat.JPG) })

        RadioButtonWithLabel(
            titleRes = R.string.general_format_webp,
            selected = selectedOption == JpgComparisonImageFormat.WEBP,
            enabled = enabled,
            onClick = { onOptionSelect(JpgComparisonImageFormat.WEBP) })
    }
}

sealed interface BenchmarkState {
    data object Idle : BenchmarkState
    data class Running(val runCount: Int) : BenchmarkState
    data class Finished(val averageTime: Int, val minTime: Int, val maxTime: Int) : BenchmarkState
}