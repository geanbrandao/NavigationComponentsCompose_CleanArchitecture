package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model

data class EpisodeModel(
    val name: String,
    val airDate: String,
    val director: String,
    val writer: String,
    val characters: List<String>,
    val imgUrl: String
)
