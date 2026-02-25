package Locations;

import Console.QuestManager;
import Rest.Player;

public class Boiler extends Location{

    private Player player;
    private QuestManager questManager;
    private String questDone;


    @Override
    public String use(String command){
        if (command.equals("coal") && player.getInventory().findItem("coal") != null){
            player.getInventory().remove(player.getInventory().findItem(command));
            questManager.setBoilerQuest(true);
            return questDone;
        }
        return null;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setQuestManager(QuestManager questManager) {
        this.questManager = questManager;
    }
}
