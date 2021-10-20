package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.R
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.NavArgsKeys.CHARACTER_NAME

sealed class Screen(
    val route: String,
    @StringRes val stringId: Int,
    val iconId: ImageVector?,
) {
    object Characters : Screen(
        route = "characters",
        iconId = Icons.Rounded.Person,
        stringId = R.string.text_default_label_bottom_navigation_characters,
    )

    object Episodes : Screen(
        route = "episodes",
        iconId = Icons.Rounded.List,
        stringId = R.string.text_default_label_bottom_navigation_episodes,
    )

    object CharactersDetails : Screen(
        route = "details",
        iconId = null,
        stringId = R.string.text_default_label_toolbar_title
    )
}

object NavArgsKeys {
    const val CHARACTER_NAME = "name"
}
