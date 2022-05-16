package com.fleme.jetpackstore.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fleme.jetpackstore.R
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

@Composable
fun CardItem(
    isFavorited: Boolean,
    clickCardAction: () -> Unit
) {
    val favoriteCurrentIcon = if (isFavorited) {
        painterResource(id = R.drawable.ic_favorite_selected)
    } else {
        painterResource(id = R.drawable.ic_favorite_unselected)
    }

    Card(backgroundColor = MaterialTheme.colors.background) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
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
                    text = "Hello Android!"
                )
                Text(
                    text = "Welcome to Jetpack Store.",
                    color = MaterialTheme.colors.primary
                )
            }

            IconButton(onClick = clickCardAction) {
                Image(
                    painter = favoriteCurrentIcon,
                    contentDescription = "Favorite icon button",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Preview(
    name = "Card Item - Light Mode",
    showBackground = true
)
@Preview(
    name = "Card Item - Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewFavoritedCardItem() {
    JetpackStoreTheme {
        CardItem(isFavorited = true) { }
    }
}

@Preview(
    name = "Card Item - Light Mode",
    showBackground = true
)
@Preview(
    name = "Card Item - Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewUnfavoritedCardItem() {
    JetpackStoreTheme {
        CardItem(isFavorited = false) { }
    }
}
