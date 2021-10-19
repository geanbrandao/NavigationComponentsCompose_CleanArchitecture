package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network


import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val origin: String,
    @SerialName("img_url")
    val imgUrl: String
)

fun CharacterResponse.toCharacterModel() = CharacterModel(
    name = name,
    imgUrl = imgUrl,
    origin = origin,
    species = species,
    status = status,
)