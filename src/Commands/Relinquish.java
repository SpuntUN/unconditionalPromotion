package Commands;

import Locations.Location;
import Rest.Inventory;
import Rest.Item;
import Rest.Player;

public class Relinquish extends Command{
    Player player;

    public Relinquish(Player player){
        this.player = player;
    }

    @Override
    public String execute(String command) {
        Inventory inv = player.getInventory();
        if (inv.findItem(command) != null){
            Item removedItem = inv.findItem(command);
            inv.remove(removedItem);
            player.getLocation().addItem(removedItem);
            return removedItem.getName() + " removed from inventory";
        }
        return "No item with the name \"" + command + "\" has been found";
    }

    @Override
    public boolean exit() {
        return super.exit();
    }
}
