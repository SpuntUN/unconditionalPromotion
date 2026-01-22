package Commands;

import Console.GameData;
import Locations.Location;
import Rest.Player;

import java.util.ArrayList;

public class Move extends Command{

    private Player player;
    public ArrayList<Location> locations;

    public Move(Player player, ArrayList<Location> locations) {
        this.player = player;
        this.locations = locations;
    }

    @Override
    public String execute(String command) {

        for (Location l : locations){
            if (command.equalsIgnoreCase(l.getName())){
                String id = l.getId();
                for (String neighbour : player.getLocation().getNeighbours()){
                    if (id.equals(neighbour)){
                        player.setLocation(l);
                        return "Moved to " + l.getName();
                    }
                }
            }
        }
        return "Not location with name " + command + " has been found";
    }

    @Override
    public boolean exit() {
        return super.exit();
    }
}
