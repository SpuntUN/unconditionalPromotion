package Commands;

import NPCs.NPC;
import Rest.Player;

import java.util.ArrayList;

public class Look extends Command{

    private Player player;
    private ArrayList<NPC> NPCs;

    public Look(Player player, ArrayList<NPC> NPCs) {
        this.player = player;
        this.NPCs = NPCs;
    }

    /**
     * Method for dropping an item into a location where player currently is.
     * @param command changes the return String depending on if the String is empty, has the name of an item, or NPC.
     * @return description of either location, item, NPC, or returns a String saying it couldn't find anything.
     */
    @Override
    public String execute(String command) {
        if (command.isEmpty()){
            return player.getLocation().getDescription() + "\n" + player.getLocation().getNeighboursDescription();
        }
        if (player.getLocation().findItem(command) != null){
            return player.getLocation().findItem(command).getDescription();
        }
        if (player.getInventory().findItem(command) != null){
            return player.getInventory().findItem(command).getDescription();
        }
        for (NPC npc : NPCs){
            if (player.getLocation().equals(npc.getLocation())){
                return npc.getDescription();
            }
        }
        return "You can't find anything like \"" + command + "\" to look at";
    }
}
