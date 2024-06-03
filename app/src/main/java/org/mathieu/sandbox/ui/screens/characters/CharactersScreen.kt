package org.mathieu.sandbox.ui.screens.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.ui.screens.episodedetails.EpisodeDetailsScreen

@Composable
fun CharactersScreen(
    navController: NavController
) {
    val viewModel: CharactersViewModel = viewModel()
    val state: CharactersState by viewModel.state.collectAsState()

    // Collect events emitted by the ViewModel.
    LaunchedEffect(viewModel.events) {
        viewModel.events
            .onEach { event ->

                when(event) {
                    is CharactersEvent.NavigateToDetails -> navController.navigate(
                        route = "characters/${event.id}"
                    )

                    null -> { }
                }

            }.collect()
    }

    Content(
        state = state,
        clickedOnCard = {
            viewModel.navigateToDetail(it)
        }
    )
}


@Composable
private fun Content(
    state: CharactersState,
    clickedOnCard: (Int) -> Unit = { }
) = Column {

    state.error?.let { error ->
        Text(text = error)
    } ?: LazyColumn {
        items(state.characters) { character ->
            CharacterCard(
                name = character.firstName,
                surname = character.lastName,
                episodes = character.presence,
                onClick = { clickedOnCard(character.id) }
            )
        }
    }

}


@Composable
private fun CharacterCard(
    name: String,
    surname: String,
    episodes: List<Episode>,
    onClick: () -> Unit
) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .clickable(onClick = onClick)
) {
    Text(text = name)
    Text(text = surname)
    Text(text = "participation :")
    for (episode in episodes) {
        EpisodeDetailsScreen(episodeId = episode.id)
    }
}


@Preview
@Composable
private fun Preview() {
    Content(state =  CharactersState())
}