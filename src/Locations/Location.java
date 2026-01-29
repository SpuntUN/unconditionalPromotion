package Locations;

import java.util.ArrayList;

public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> stored;
    private ArrayList<String> neighbours;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getNeighbours() {
        return neighbours;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return id;
    }
}
