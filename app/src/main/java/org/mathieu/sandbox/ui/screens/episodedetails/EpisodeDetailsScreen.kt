package org.mathieu.sandbox.ui.screens.episodedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


/**
 * A card with the different information from the episode
 */
@Composable
fun CardEpisodeDetailsScreen(
    navController: NavController,
    episodeId: Int
) {
    val viewModel: EpisodeDetailsViewModel = viewModel()
    val state: EpisodeDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = episodeId)
    }
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            EpisodeDetailsScreen(
                state = state
            )
        }
    }
}

/**
 * A text with the different information of the episode
 */
@Composable
private fun EpisodeDetailsScreen(
    state: EpisodeDetailsState
) =
    Column {
        Text(text = state.name)
        Text(text = state.date)     }


@Preview
@Composable
private fun Preview() {
    EpisodeDetailsScreen(
        state = EpisodeDetailsState(name = "Friends: The One Where Ross Finds Out",
                                    date = "novembre 9, 1995")
    )
}