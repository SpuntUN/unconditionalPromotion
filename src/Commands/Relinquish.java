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


    /**
     * Relocates an item out of player's inventory into a locations storage.
     * @param command name of an item currently in inventory.
     * @return either message that player has successfully dropped the item, or that it couldn't find the corresponding item.
     */
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

}
