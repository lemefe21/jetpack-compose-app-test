package com.fleme.jetpackstore

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fleme.jetpackstore.data.Message
import com.fleme.jetpackstore.sample.SampleMessageData
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

@Composable
fun CardItem(name: String) {
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

@Composable
fun MessageCard(msg: Message) {
    Row(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )

        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = msg.auhtor,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = checkStateToGetMaxLines(isExpanded),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

private fun checkStateToGetMaxLines(isExpanded: Boolean) = if (isExpanded) Int.MAX_VALUE else 1

@Preview(name = "Light Mode",
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
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewConversation() {
    JetpackStoreTheme {
        Conversation(messages = SampleMessageData.conversationSample)
    }
}
