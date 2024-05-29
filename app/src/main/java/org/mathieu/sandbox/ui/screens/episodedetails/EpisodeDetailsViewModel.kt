package org.mathieu.sandbox.ui.screens.episodedetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.EpisodeRepositoryImpl

/**
 * ViewModel for handling episode details.
 * This ViewModel is responsible for managing the state related to episode details.
 */
class EpisodeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<EpisodeDetailsState> = MutableStateFlow(EpisodeDetailsState())

    val state: StateFlow<EpisodeDetailsState>
        get() = _state

    fun initialize(id: Int) {
        val episode = EpisodeRepositoryImpl.getEpisodeByIdOrNull(id)!!

        _state.value = EpisodeDetailsState(
            name = episode.name,
            date = episode.date
        )

    }

}



data class EpisodeDetailsState(
    val name: String = "",
    val date: String = ""
)