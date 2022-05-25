package com.fleme.jetpackstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fleme.jetpackstore.ui.compose.AppLaunchGreeting
import com.fleme.jetpackstore.ui.theme.JetpackStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackStoreTheme {
                AppLaunchGreeting()
            }
        }
    }
}
