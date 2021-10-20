package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.characters.content

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.characters.viewModel.CharactersViewModel

@Composable
fun CharacterScreen(
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val charactersState = remember {
        viewModel.charactersState
    }
    Log.d("DEBUG#", "${charactersState.value.size}")
    LazyColumn(contentPadding = PaddingValues(vertical = 4.dp)) {
        items(charactersState.value) { character ->
            CharacterItem(characterModel = character) {
                Log.d("DEBUG#", "goToCharacterDetails")
            }
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}