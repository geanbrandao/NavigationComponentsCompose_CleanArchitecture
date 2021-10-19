package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository

import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.CharacterModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.EpisodeModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.ApiService
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.toCharacterModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.toEpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiService,
) : Repository {

    override fun getCharacters(): Flow<List<CharacterModel>> = flow {
        emit(api.getCharacters().map { it.toCharacterModel() })

    }

    override fun getEpisodes(): Flow<List<EpisodeModel>> = flow {
        emit(api.getEpisodes().map { it.toEpisodeModel() })
    }
}