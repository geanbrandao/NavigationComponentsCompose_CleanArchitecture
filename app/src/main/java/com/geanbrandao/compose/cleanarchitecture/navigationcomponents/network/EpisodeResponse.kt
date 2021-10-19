package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network


import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.EpisodeModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    @SerialName("air_date")
    val airDate: String,
    val director: String,
    val writer: String,
    val characters: List<String>,
    @SerialName("img_url")
    val imgUrl: String
)

fun EpisodeResponse.toEpisodeModel() = EpisodeModel(
    imgUrl = imgUrl,
    name = name,
    airDate = airDate,
    characters = characters,
    director = director,
    writer = writer,
)