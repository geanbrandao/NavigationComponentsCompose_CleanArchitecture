package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_episodes.content

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.Screen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.AllMarginDefault
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_characters.content.BottomNavigationHeight
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.screen_episodes.viewModel.EpisodesViewModel

@Composable
fun EpisodesScreen(
    viewModel: EpisodesViewModel = hiltViewModel()
) {
    val episodeState = remember {
        viewModel.episodesState
    }
    Log.d("DEBUG#", "${episodeState.value.size}")
    LazyColumn(contentPadding = PaddingValues(top = AllMarginDefault, bottom = BottomNavigationHeight)) {
        items(episodeState.value) { episode ->
            EpisodeItem(episodeModel = episode) {
                // goToCharacterDetails
                Log.d("DEBUG#", "goToEpisodeDetails")
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = AllMarginDefault)
                    .height(height = 1.dp)
                    .background(color = MaterialTheme.colors.primary)
            )
        }
    }
}