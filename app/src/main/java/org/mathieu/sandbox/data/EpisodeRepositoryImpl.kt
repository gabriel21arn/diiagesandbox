package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.domain.repositories.IEpisodeRepository

object EpisodeRepositoryImpl : IEpisodeRepository {

    /**
     * Try to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode that we are looking for
     * @return It returns either an [Episode] or null if not found.
     */
    override fun getEpisodeByIdOrNull(id: Int): Episode? {

        return EpisodeLocal.episodes.find { episode ->
            episode.id == id
        }

    }

    /**
     * Try to retrieve all Episode. If there is no episodes found, then it returns null.
     *
     * @return It returns either an episode list or null if not found.
     */
    override fun getEpisodes() = EpisodeLocal.episodes

}