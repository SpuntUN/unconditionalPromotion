package Locations;

import Console.QuestManager;
import Rest.Player;

public class Damaged extends Location{

    private Player player;
    private QuestManager questManager;
    private String sealed;
    private String newDescription;

    @Override
    public String use(String command) {
        if (command.equals("duct tape") && player.getInventory().findItem("duct tape") != null && !questManager.isHullQuest()){
            questManager.setHullQuest(true);
            player.getInventory().remove(player.getInventory().findItem("duct tape"));
            description = newDescription;
            return sealed;
        }
        return null;
    }
}
