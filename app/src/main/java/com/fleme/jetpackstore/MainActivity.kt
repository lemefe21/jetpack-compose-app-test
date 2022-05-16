package com.fleme.jetpackstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fleme.jetpackstore.ui.compose.CardItem
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackStoreTheme {
                var isSelected by remember { mutableStateOf(false) }

                CardItem(isFavorited = isSelected) {
                    isSelected = !isSelected
                }
            }
        }
    }
}
