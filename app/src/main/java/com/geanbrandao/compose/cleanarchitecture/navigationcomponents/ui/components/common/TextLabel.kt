package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.characters.content.TextSizeLabel


@Composable
fun TextLabel(label: String, modifier: Modifier) {
    Text(
        text = label,
        modifier = modifier,
        fontSize = TextSizeLabel,
        fontWeight = FontWeight.Light,
        color = MaterialTheme.colors.primaryVariant
    )
}