package Commands;

import Rest.Item;
import Rest.Player;

import java.util.ArrayList;

public class Take extends Command {

    Player player;
    public ArrayList<Item> items;

    public Take(Player player, ArrayList<Item> items){
        this.player = player;
        this.items = items;
    }

    @Override
    public String execute(String command) {
        for (Item i : items){
            if (command.equalsIgnoreCase(i.getName()) && player.getLocation().getNeighbours().contains(i.getId())){
                player.getInventory().add(i);
                player.getLocation().getNeighbours().remove(i.getId());
                return i.getName() + " has been added to inventory";
            }
        }
        return "No item with the name \"" + command + "\" has been found";
    }

    @Override
    public boolean exit() {
        return super.exit();
    }
}
