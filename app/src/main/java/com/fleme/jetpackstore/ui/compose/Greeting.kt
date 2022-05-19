package com.fleme.jetpackstore.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }

            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(text = if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewGreeting() {
    JetpackStoreTheme {
        Greeting(name = "Androd")
    }
}

@Composable
fun GreetingList(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320
)
@Composable
fun PreviewGreetingList() {
    JetpackStoreTheme {
        GreetingList()
    }
}

@Composable
fun AppLaunchGreeting() {
    var shouldShowOnboardingScreen by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboardingScreen) {
        OnboardingScreen(onContinueClicked = {shouldShowOnboardingScreen = false})
    } else {
        GreetingList()
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewAppLaunchGreeting() {
    JetpackStoreTheme {
        AppLaunchGreeting()
    }
}