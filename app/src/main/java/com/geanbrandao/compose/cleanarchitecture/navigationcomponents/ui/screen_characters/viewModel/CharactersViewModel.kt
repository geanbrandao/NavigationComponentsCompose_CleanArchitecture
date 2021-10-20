package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.CharacterModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: Repository,
): ViewModel() {

    private val _charactersState = mutableStateOf<List<CharacterModel>>(emptyList())
    val charactersState: State<List<CharacterModel>> = _charactersState

    init {
        getCharacters()
    }

    private fun getCharacters() {
        repository.getCharacters().onEach { result: List<CharacterModel> ->
            _charactersState.value = result
        }.launchIn(viewModelScope)
    }
}