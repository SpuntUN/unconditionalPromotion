package Locations;

import Rest.Item;

import java.util.ArrayList;

public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> storedId;
    private ArrayList<Item> stored;
    private ArrayList<String> neighboursId;
    private ArrayList<Location> neighbours;

    public boolean equalsNeighbourName(String str){
        for (Location l : neighbours){
            if (l.getName().equalsIgnoreCase(str)){
                return true;
            }
        }
        return false;
    }

    public Location findNeighbour(String str){
        for (Location l : neighbours){
            if (l.getName().equalsIgnoreCase(str)){
                return l;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getNeighboursId() {
        return neighboursId;
    }

    public boolean addNeighbour(Location l){
        return neighbours.add(l);
    }

    public ArrayList<String> getStoredId() {
        return storedId;
    }

    public boolean addStored(Item i){
        return stored.add(i);
    }

    public String getDescription() {

        return description;
    }

    @Override
    public String toString() {
        return id;
    }
}
