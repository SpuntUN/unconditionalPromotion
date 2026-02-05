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

    @Override
    public String execute(String command) {
        if (command.isEmpty()){
            return player.getLocation().getDescription();
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

    @Override
    public boolean exit() {
        return super.exit();
    }
}
