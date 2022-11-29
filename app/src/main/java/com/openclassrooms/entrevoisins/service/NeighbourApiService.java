package com.openclassrooms.entrevoisins.service;


import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Gets all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     *
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Creates a neighbour
     *
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Gets all favorite neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Creates a neighbour
     *
     * @param id
     */
    Neighbour getNeighbourById(long id);


    /**
     * Updates a neighbour to favorite/unfavorite
     * @param neighbour
     * @param neighbourId
     */
    void updateFavoriteNeighbour(Neighbour neighbour, long neighbourId);

}
