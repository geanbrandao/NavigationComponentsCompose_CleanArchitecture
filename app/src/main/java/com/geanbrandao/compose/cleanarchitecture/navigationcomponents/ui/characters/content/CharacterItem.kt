package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.characters.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.R
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.model.CharacterModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common.TextLabel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common.TextName
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterItem(characterModel: CharacterModel, onClick: () -> Unit) = with(characterModel) {
    Row(
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
            imageModel = imgUrl,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(size = 100.dp)
                .align(Alignment.CenterVertically)
        )
        Column {
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
                label = stringResource(R.string.text_default_label_specie),
                modifier = modifierTextLabel
            )
            TextName(
                name = species,
                modifier = modifierTextName
            )
        }
    }
}

@Preview(name = "Character Item")
@Composable
private fun CharacterItemPreview() {
    val characterModel = CharacterModel(
        name = "Gary Goodspeed",
        imgUrl = "https://finalspaceapi.com/api/character/avatar/gary_goodspeed.png",
        status = "Alive",
        species = "Human",
        origin = "Earth",
    )
    CharacterItem(characterModel = characterModel) {

    }
}