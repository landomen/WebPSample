package com.landomen.webpsample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.landomen.webpsample.R
import com.landomen.webpsample.ui.model.ScreenSelection

@Composable
internal fun IntroScreen(
    onScreenSelect: (ScreenSelection) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        Text(
            text = stringResource(id = R.string.intro_description),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(ScreenSelection.entries.size) { index ->
                val screenSelection = ScreenSelection.entries[index]
                Button(
                    onClick = { onScreenSelect(screenSelection) },
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(text = stringResource(id = screenSelection.titleRes))
                }
            }
        }
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    Surface {
        IntroScreen(
            onScreenSelect = {},
        )
    }
}