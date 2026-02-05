package Locations;

import Rest.Item;

import java.util.ArrayList;

public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<Item> stored;
    private ArrayList<String> neighboursId;
    private ArrayList<Location> neighbours;

    public Location findNeighbour(String str){
        for (Location l : neighbours){
            if (l.getName().split(" ")[0].equalsIgnoreCase(str.split(" ")[0])){
                return l;
            }
        }
        return null;
    }

    public Item findItem(String str){
        for (Item i : stored){
            if (i.getName().split(" ")[0].equalsIgnoreCase(str.split(" ")[0])){
                return i;
            }
        }
        return null;
    }

    public boolean addItem(Item item){
        return stored.add(item);
    }

    public boolean removeItem(Item item){
        return stored.remove(item);
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

    public ArrayList<Item> getStored() {
        return stored;
    }

    public ArrayList<Location> getNeighbours() {
        return neighbours;
    }



    public boolean addNeighbour(Location l){
        return neighbours.add(l);
    }


    public boolean addStored(Item i){
        return stored.add(i);
    }

    public String getDescription() {

        return description;
    }

    public String getNeighboursDescription(){
        String str = "This location neighbours ";
        if (neighbours.size() > 1){
            for (int i = 0; i < neighbours.size()-1; i++) {
                str += neighbours.get(i).getName() + ", ";
            }
            str += "and " + neighbours.getLast().getName();
            return str;
        }
        return str + neighbours.getFirst().getName();
    }

    @Override
    public String toString() {
        return id;
    }
}
