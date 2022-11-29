package com.openclassrooms.entrevoisins.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    /**
     * Fetch all neighbours
     */
    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        MatcherAssert.assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    /**
     * Delete one neighbour
     */
    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    /**
     * Add a freshly created neighbour and verify
     * if they're correctly added to the neighbour list
     */
    @Test
    public void addingNewNeighbourWithSuccess() {
        Neighbour newNeighbour = new Neighbour(
                System.currentTimeMillis(),
                "John Doe",
                "https://test.url",
                "Anytown",
                "0101010101",
                "Lorem ipsum"
        );
        service.createNeighbour(newNeighbour);
        assertTrue(service.getNeighbours().contains(newNeighbour));
    }

    /**
     * Update a neighbour to favorite, then verify if they are favorite
     */
    @Test
    public void setNeighbourFavWithSuccess() {
        Neighbour neighbourFav = service.getNeighbours().get(0);
        service.updateFavoriteNeighbour(neighbourFav, neighbourFav.getId());
        assertTrue(neighbourFav.isFavorite());
    }

    /**
     * Update a created neighbour to favorite, then verify if they are favorite
     */
    @Test
    public void setCreatedNeighbourFavWithSuccess() {
        Neighbour newNeighbour = new Neighbour(
                System.currentTimeMillis(),
                "John Doe",
                "https://test.url",
                "Anytown",
                "0101010101",
                "Lorem ipsum"
        );
        service.createNeighbour(newNeighbour);
        service.updateFavoriteNeighbour(newNeighbour, newNeighbour.getId());
        assertTrue(newNeighbour.isFavorite());
    }

    /**
     * Set neighbour to fav, then unfav them
     */
    @Test
    public void unsetNeighbourFavWithSuccess() {
        Neighbour neighbourFav = service.getNeighbours().get(1);
        service.updateFavoriteNeighbour(neighbourFav, neighbourFav.getId());
        service.updateFavoriteNeighbour(neighbourFav, neighbourFav.getId());
        assertFalse(service.getFavoriteNeighbours().contains(neighbourFav));
    }

    /**
     * Get neighbour id
     * neighbour at index 2, so the id is 3
     */
    @Test
    public void getUserIdWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(2);
        assertEquals(neighbour, service.getNeighbourById(3));
    }

}
