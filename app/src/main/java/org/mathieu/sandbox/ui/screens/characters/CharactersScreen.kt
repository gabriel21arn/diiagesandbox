package org.mathieu.sandbox.ui.screens.characters

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.mathieu.sandbox.domain.models.Episode

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
                    is CharactersEvent.NavigateToEpisodeDetails -> navController.navigate(
                        route = "episode/${event.id}"
                    )
                    null -> { }
                }

            }.collect()
    }

    Content(
        state = state,
        clickedOnCard = {
            viewModel.navigateToDetail(it)
        },
        clickedOnEpisode = {
            viewModel.navigateToEpisodeDetail(it)
        }

    )
}


@Composable
private fun Content(
    state: CharactersState,
    clickedOnCard: (Int) -> Unit = { },
    clickedOnEpisode: (Int) -> Unit = { }
) = Column {
    state.error?.let { error ->
        Text(text = error)
    } ?: LazyColumn {
        items(state.characters) { character ->
            CharacterCard(
                name = character.firstName,
                surname = character.lastName,
                episodes = character.presence,
                onClick = { clickedOnCard(character.id) },
                onEpisodeClick = { clickedOnEpisode(it) }
            )
        }
    }
}


/**
 * A character's card with their name,
 * surname and a list of episodes they appear in.
 * Each episode is clickable and navigates to the episode's details when clicked.
 */
@Composable
private fun CharacterCard(
    name: String,
    surname: String,
    episodes: List<Episode>,
    onClick: () -> Unit,
    onEpisodeClick: (Int) -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable{
                vibratePhone(context)
                onClick()
            }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = name)
            Text(text = surname)
            episodes.forEach { episode ->
                EpisodeCard(title = episode.name, onClick = { onEpisodeClick(episode.id) })
            }
        }
    }
}

/**
 * An episode's card with its title.
 * The card is clickable and triggers the provided onClick callback.
 */
@Composable
private fun EpisodeCard(
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(onClick = onClick)
    ) {
        Text(text = title, modifier = Modifier.padding(8.dp))
    }
}



private fun vibratePhone(context: Context) {
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    val vibrationEffect = VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE)
    vibrator.vibrate(vibrationEffect)
}

@Preview
@Composable
private fun Preview() {
    Content(state =  CharactersState())
}