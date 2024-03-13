package com.landomen.webpsample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun IntroScreen(
    onPngSelect: () -> Unit,
    onJpgSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        Text(
            text = "This is a sample project to compare image quality between PNG/JPG and WebP.\n\nSelect a comparison test to get started.",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onPngSelect,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(text = "PNG vs WebP")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onJpgSelect,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(text = "JPG vs WebP")
        }
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    Surface {
        IntroScreen(
            onPngSelect = {},
            onJpgSelect = {}
        )
    }
}