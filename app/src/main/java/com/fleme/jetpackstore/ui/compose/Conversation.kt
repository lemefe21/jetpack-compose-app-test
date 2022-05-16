package com.fleme.jetpackstore.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fleme.jetpackstore.data.Message
import com.fleme.jetpackstore.sample.SampleMessageData
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

@Composable
fun Conversation(messages: List<Message>) {
    // LazyColumn or LazyRow is the Compose version's of a RecyclerView.
    LazyColumn {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewConversation() {
    JetpackStoreTheme {
        Conversation(messages = SampleMessageData.conversationSample)
    }
}