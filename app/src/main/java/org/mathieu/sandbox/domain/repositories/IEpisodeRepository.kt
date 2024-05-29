package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode

interface IEpisodeRepository {
    /**
     * Try to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode that we are looking for
     * @return It returns either a [Episode] or null if not found.
     */
    fun getEpisodeByIdOrNull(id: Int): Episode?

    /**
     * Try to retrieve all Episode. If there is no episodes found, then it returns null.
     *
     * @return It returns either an episode list or null if not found.
     */
    fun getEpisodes(): List<Episode>?
}