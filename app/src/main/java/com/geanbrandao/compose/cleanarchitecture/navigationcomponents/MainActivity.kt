package com.geanbrandao.compose.cleanarchitecture.navigationcomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.characters.content.CharacterScreen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.characters.viewModel.CharactersViewModel
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.episodes.content.EpisodesScreen
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.theme.NavigationComponentsComposeCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComponentsComposeCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    EpisodesScreen()
                    CharacterScreen()
                }
            }
        }
    }
}