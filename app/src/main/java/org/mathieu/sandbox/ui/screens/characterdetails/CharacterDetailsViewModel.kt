package org.mathieu.sandbox.ui.screens.characterdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import org.mathieu.sandbox.domain.models.Episode

class CharacterDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<CharacterDetailsState> = MutableStateFlow(CharacterDetailsState())

    val state: StateFlow<CharacterDetailsState>
        get() = _state

    fun initialize(id: Int) {
        val character = CharacterRepositoryImpl.getCharacterByIdOrNull(id)!!

        _state.value = CharacterDetailsState(
            firstName = character.firstName,
            lastName = character.lastName,
            episodes = character.presence
        )

    }

}



data class CharacterDetailsState(
    val firstName: String = "",
    val lastName: String = "",
    val episodes: List<Episode> = mutableListOf()
)