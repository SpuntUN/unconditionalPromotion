package Rest;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean add(Item item){
        if (items.size() + 1 > capacity){
            return false;
        }
        return items.add(item);
    }

    public String getInventoryNames(){
        String str = "INVENTORY:";
        for (Item item : items){
            str += "\n" +  item.getName();
        }
        return str;
    }

    public boolean remove(){
        return false;
    }

}
