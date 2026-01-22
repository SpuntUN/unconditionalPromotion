package Locations;

import Rest.Inventory;

import java.util.ArrayList;

public class Location {
    private String id;
    private String name;
    private String description;
    private Inventory storage;
    private ArrayList<Location> neighbours;

    public String getId() {
        return id;
    }
}
