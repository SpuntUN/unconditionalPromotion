package Items;

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

    public boolean remove(Item item){
        return items.remove(item);
    }

    public Item findItem(String str){
        for (Item i : items){
            if (i.getName().split(" ")[0].equalsIgnoreCase(str.split(" ")[0])){
                return i;
            }
        }
        return null;
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
