package Rest;

import Items.Inventory;
import Locations.Location;

public class Player {
    private Location location;
    private Inventory inventory;

    public Player(){
        inventory = new Inventory(2);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Inventory getInventory(){
        return inventory;
    }
}
