package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository

import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.CharacterModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getCharacters(): Flow<List<CharacterModel>>

    fun getEpisodes(): Flow<List<EpisodeModel>>
}