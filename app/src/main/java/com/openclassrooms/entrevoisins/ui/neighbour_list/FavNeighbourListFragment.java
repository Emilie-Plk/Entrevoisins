package com.openclassrooms.entrevoisins.ui.neighbour_list;


import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


public class FavNeighbourListFragment extends GenericNeighbourListFragment {

    /**
     * Create and return a new instance
     * @return @{@link FavNeighbourListFragment}
     */
    public static FavNeighbourListFragment newInstance() {
        FavNeighbourListFragment fragment = new FavNeighbourListFragment();
        return fragment;
    }

    @Override
    List<Neighbour> getNeighboursData() {
        return mApiService.getFavoriteNeighbours();
    }

}
