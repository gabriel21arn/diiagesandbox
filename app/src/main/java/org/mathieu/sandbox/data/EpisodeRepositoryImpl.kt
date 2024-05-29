package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.repositories.IEpisodeRepository

object EpisodeRepositoryImpl : IEpisodeRepository {

    /**
     * Try to retrieve all Episode. If there is no episodes found, then it returns null.
     *
     * @return It returns either a episode list or null if not found.
     */
    override fun getEpisodes() = EpisodeLocal.episodes

}