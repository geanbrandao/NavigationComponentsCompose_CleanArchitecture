package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.TextSizeDefault
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.TextSizeLabel

@Composable
fun TextName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = TextSizeDefault,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.primary,
    )
}