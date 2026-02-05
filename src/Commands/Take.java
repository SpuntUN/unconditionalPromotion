package Commands;

import Locations.Location;
import Rest.Item;
import Rest.Player;

import java.util.ArrayList;

public class Take extends Command {

    Player player;

    public Take(Player player){
        this.player = player;
    }

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
