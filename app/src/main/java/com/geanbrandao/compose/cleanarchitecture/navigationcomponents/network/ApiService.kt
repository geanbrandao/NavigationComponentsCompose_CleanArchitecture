package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface ApiService {

    suspend fun getCharacters(): List<CharacterResponse>

    suspend fun getEpisodes(): List<EpisodeResponse>
}