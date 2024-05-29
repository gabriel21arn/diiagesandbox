package org.mathieu.sandbox.domain.models

/**
 * Character class with a unique identifier,firstName, lastName and age.
 *
 * @property id Unique identifier.
 * @property firstName first name.
 * @property lastName Last name.
 * @property age Age in number of years.
 */
data class Character(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
)