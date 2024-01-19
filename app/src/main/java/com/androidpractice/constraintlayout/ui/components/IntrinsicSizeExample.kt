package com.androidpractice.constraintlayout.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MyTextField(text: String, onTextChange: (String) -> Unit) {
    TextField(value = text, onValueChange = onTextChange)
}
