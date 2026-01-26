package Rest;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(Item item){
        if (items.size() + 1 > capacity){
            return false;
        }
        return items.add(item);
    }

    public boolean remove(){
        return false;
    }

}
