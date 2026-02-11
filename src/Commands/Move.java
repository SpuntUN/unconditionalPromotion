package Commands;

import Console.GameData;
import Locations.Location;
import Rest.Player;

import java.util.ArrayList;

public class Move extends Command{

    private Player player;

    public Move(Player player) {
        this.player = player;
    }

    /**
     * Moves the player to a different location.
     * @param command contains the name of a neighbouring location to the player.
     * @return either message that player has successfully moved to a location, or that it couldn't find the corresponding location.
     */

    @Override
    public String execute(String command) {
        Location current = player.getLocation();
        if (current.findNeighbour(command) != null){
            player.setLocation(current.findNeighbour(command));
            return "Moved to " + player.getLocation().getName();
        }
        return "No location with the name \"" + command + "\" has been found";
    }


    @Override
    public boolean exit() {
        return super.exit();
    }
}
