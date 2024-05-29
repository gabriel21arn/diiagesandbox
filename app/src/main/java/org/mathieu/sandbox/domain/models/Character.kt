package org.mathieu.sandbox.domain.models

/**
 * Character class with a unique identifier,firstName, lastName and age.
 *
 * @property id Unique identifier.
 * @property firstName first name.
 * @property lastName Last name.
 * @property age Age in number of years.
 * @property presence List of episodes in which the character is mentioned or appears.
 */
data class Character(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val presence : List<Episode>
)