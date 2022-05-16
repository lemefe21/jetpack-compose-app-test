package com.fleme.jetpackstore.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.fleme.jetpackstore.data.Message

@Composable
fun Conversation(messages: List<Message>) {
    // LazyColumn or LazyRow is the Compose version's of a RecyclerView.
    LazyColumn {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}