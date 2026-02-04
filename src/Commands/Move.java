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

    @Override
    public String execute(String command) {
        Location current = player.getLocation();
        if (current.equalsNeighbourName(command)){
            player.setLocation(current.findNeighbour(command));
        }
        return "No location with the name \"" + command + "\" has been found";
    }

    @Override
    public boolean exit() {
        return super.exit();
    }
}
