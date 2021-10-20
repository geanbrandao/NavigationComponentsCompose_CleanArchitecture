package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_episodes.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.R
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.EpisodeModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.AllMarginDefault
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.AllMarginHalf
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common.TextLabel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common.TextName
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun EpisodeItem(episodeModel: EpisodeModel, onClick: () -> Unit) = with(episodeModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick()
            }
    ) {
        val modifierTextName = Modifier
            .padding(horizontal = AllMarginDefault)
        val modifierTextLabel = Modifier
            .padding(horizontal = AllMarginDefault)
        GlideImage(
            imageModel = imgUrl.replace("http", "https"),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillWidth,
        )
        TextLabel(
            label = stringResource(R.string.text_default_label_name),
            modifier = modifierTextLabel
        )
        TextName(
            name = name,
            modifier = modifierTextName
        )
        Spacer(modifier = Modifier.size(size = AllMarginHalf))
        TextLabel(
            label = stringResource(R.string.text_default_label_air_date),
            modifier = modifierTextLabel
        )
        TextName(
            name = airDate,
            modifier = modifierTextName
        )
    }
}

@Preview(name = "Character Item")
@Composable
private fun CharacterItemPreview() {
    val episodeModel = EpisodeModel(
        name = "Chapter 1",
        imgUrl = "https://finalspaceapi.com/api/episode/image/chapter1.jpg",
        writer = "Olan Rogers",
        director = "Mike Roberts",
        characters = listOf(
            "https://finalspaceapi.com/api/v0/character/1",
            "https://finalspaceapi.com/api/v0/character/2",
            "https://finalspaceapi.com/api/v0/character/3",
            "https://finalspaceapi.com/api/v0/character/5",
            "https://finalspaceapi.com/api/v0/character/6",
            "https://finalspaceapi.com/api/v0/character/9",
            "https://finalspaceapi.com/api/v0/character/11"
        ),
        airDate = "02/15/2018",
    )
    EpisodeItem(episodeModel = episodeModel) {

    }
}