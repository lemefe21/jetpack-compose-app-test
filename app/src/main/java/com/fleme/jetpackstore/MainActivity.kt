package com.fleme.jetpackstore

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardItem("Android")
        }
    }
}

@Composable
fun CardItem(name: String) {
    JetpackStoreTheme {
        Card(backgroundColor = MaterialTheme.colors.background) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_jetpack_compose),
                    contentDescription = "Item",
                    modifier = Modifier
                        .size(56.dp)
                        .padding(end = 2.dp)
                )
                Column {
                    Text(
                        text = "Hello $name!"
                    )
                    Text(
                        text = "Welcome to Jetpack Store.",
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    CardItem("Android")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewToUsers() {
    CardItem("User")
}
