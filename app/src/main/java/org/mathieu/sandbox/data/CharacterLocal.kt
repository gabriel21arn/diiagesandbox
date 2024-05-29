package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode

object CharacterLocal {
    var characters: MutableList<Character> = mutableListOf(
        Character(
            id = 1,
            firstName = "John",
            lastName = "Snow",
            age = 20,
            presence = mutableListOf(
                Episode(
                    id = 1,
                    name = "Pirates of the Caribbean: The Curse of the Black Pearl",
                    date = "aout 13, 2003"
                ),
                Episode(
                    id = 2,
                    name = "Pirates of the Caribbean: Dead Man's Chest",
                    date = "juillet 7, 2006"
                )
            )
        ),
        Character(
            id = 2,
            firstName = "Jack",
            lastName = "Sparrow",
            age = 21,
            presence = mutableListOf(
                Episode(
                    id = 3,
                    name = "Game of Thrones: Winter is Coming",
                    date = "avril 17, 2011"
                ),
                Episode(
                    id = 4,
                    name = "Game of Thrones: The Rains of Castamere",
                    date = "juin 2, 2013"
                ),
                Episode(
                    id = 5,
                    name = "Game of Thrones: Battle of the Bastards",
                    date = "juin 19, 2016"
                )
            )
        ),
        Character(
            id = 3,
            firstName = "Jordan",
            lastName = "Emma",
            age = 22,
            presence = mutableListOf(
                Episode(
                    id = 6,
                    name = "Friends: The One Where Ross Finds Out",
                    date = "novembre 9, 1995"
                ),

                    Episode(
                    id = 7,
                    name = "Friends: The One with All the Rugby",
                    date = "janvier 15, 1998"
                ),

                    Episode(
                    id = 8,
                    name = "Friends: The Last One",
                    date = "mai 6, 2004"
                )
            )
        )
    )
}