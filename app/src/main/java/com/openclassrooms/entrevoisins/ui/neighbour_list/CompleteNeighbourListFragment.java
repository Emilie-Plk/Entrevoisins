package com.openclassrooms.entrevoisins.ui.neighbour_list;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


public class CompleteNeighbourListFragment extends GenericNeighbourListFragment {

    /**
     * Create and return a new instance
     *
     * @return @{@link CompleteNeighbourListFragment}
     */
    public static CompleteNeighbourListFragment newInstance() {
        CompleteNeighbourListFragment fragment = new CompleteNeighbourListFragment();
        return fragment;
    }

    @Override
    List<Neighbour> getNeighboursData() {
        return mApiService.getNeighbours();
    }

}
