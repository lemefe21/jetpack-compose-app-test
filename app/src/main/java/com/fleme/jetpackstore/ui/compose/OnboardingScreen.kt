package com.fleme.jetpackstore.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit
) {
    // This state should be hoisted
    // var shouldShowOnboardingScreen by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Jetpack Store!")
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320
)
@Composable
fun PreviewOnboardingScreen() {
    JetpackStoreTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}
