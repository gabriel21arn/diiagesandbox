package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Episode

interface IEpisodeRepository {
    /**
     * Try to retrieve all Episode. If there is no episodes found, then it returns null.
     *
     * @return It returns either a episode list or null if not found.
     */
    fun getEpisodes(): List<Episode>
}