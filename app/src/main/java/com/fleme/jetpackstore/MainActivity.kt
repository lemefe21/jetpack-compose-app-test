package com.fleme.jetpackstore

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fleme.jetpackstore.data.Message
import com.fleme.jetpackstore.sample.SampleMessageData
import com.fleme.jetpackstore.ui.compose.CardItem
import com.fleme.jetpackstore.ui.compose.Conversation
import com.fleme.jetpackstore.ui.compose.MessageCard
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackStoreTheme {
                Conversation(messages = SampleMessageData.conversationSample)
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewCardItem() {
    JetpackStoreTheme {
        CardItem("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardItemToUser() {
    JetpackStoreTheme {
        CardItem("User")
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMessageCard() {
    JetpackStoreTheme {
        MessageCard(
            msg = Message(
                auhtor = "Android",
                body = "Jetpack Compose Component"
            )
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewMessageCardWithSystemUi() {
    JetpackStoreTheme {
        MessageCard(
            msg = Message(
                auhtor = "Android",
                body = "Jetpack Compose"
            )
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewConversation() {
    JetpackStoreTheme {
        Conversation(messages = SampleMessageData.conversationSample)
    }
}
