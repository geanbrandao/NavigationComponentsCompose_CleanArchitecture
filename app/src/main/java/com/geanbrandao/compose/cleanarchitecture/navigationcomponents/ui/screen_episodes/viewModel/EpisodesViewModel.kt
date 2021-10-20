package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_episodes.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.EpisodeModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _episodesState = mutableStateOf<List<EpisodeModel>>(emptyList())
    val episodesState: State<List<EpisodeModel>> = _episodesState

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        repository.getEpisodes().onEach { result: List<EpisodeModel> ->
            _episodesState.value = result
        }.launchIn(viewModelScope)
    }
}