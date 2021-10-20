package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_character_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.Screen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common.TextName
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common.ToolbarCustom

@Composable
fun CharacterDetailsScreen(
    characterName: String,
    onArrowBackClickListener: () -> Unit,
) {
    Column() {
        ToolbarCustom(
            toolbarTitleId = Screen.Characters.stringId
        ) {
            // mustGoBack
            onArrowBackClickListener()
        }
        TextName(name = characterName, modifier = Modifier.padding(64.dp))
//        CharacterItem() {
//
//        }
    }
}