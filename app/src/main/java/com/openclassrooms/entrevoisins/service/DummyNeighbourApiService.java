package com.openclassrooms.entrevoisins.service;


import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favNeighbourList = new ArrayList<>();
        for (Neighbour neighbour : neighbours) {
            if (neighbour.isFavorite())
                favNeighbourList.add(neighbour);
        }
        return favNeighbourList;
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     */
    @Override
    public Neighbour getNeighbourById(long id) {
        for (Neighbour neighbour : neighbours) {
            if (neighbour.getId() == id) {
                return neighbour;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     * @param id
     */
    @Override
    public void updateFavoriteNeighbour(Neighbour neighbour, long id) {
        for (Neighbour neighbourFav : neighbours) {
            // loops in the neighbours list and matches with the serialized neighbour object
            if (neighbourFav.getId() == id) {
                neighbour.setFavorite(!neighbour.isFavorite());
                break;
            }
        }
    }
}
