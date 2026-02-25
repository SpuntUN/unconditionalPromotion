package Commands;

import Locations.Location;
import Items.Item;
import Rest.Player;

public class Take extends Command {

    Player player;

    public Take(Player player){
        this.player = player;
    }


    /**
     * Relocates an item out of locations storage into player's inventory.
     * @param command name of an item currently in storage in a location the player is in.
     * @return either message that player has successfully taken the item, or that it couldn't find the corresponding item.
     * @author Matěj Švec
     */
    @Override
    public String execute(String command) {
        Location current = player.getLocation();
        if (current.findItem(command) != null){
            Item addedItem = current.findItem(command);
            if (!player.getInventory().add(current.findItem(command))){
                return "Full inventory";
            }
            current.removeItem(addedItem);
            return addedItem.getName() + " added to inventory" + "\n" + addedItem.getDescription();
        }
        return "No item with the name \"" + command + "\" has been found";
    }

}
