package org.mathieu.sandbox.domain.models

/**
 * Episode class with a unique identifier, date, and name.
 *
 * @property id Unique identifier for the episode.
 * @property date Release date of the episode in string format month number, year.
 * @property name Name or title of the episode.
 */
data class Episode(
    val id: Int,
    val date: String,
    val name: String
)