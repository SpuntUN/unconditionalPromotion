package Locations;

import Console.QuestManager;
import Rest.Player;

public class Boiler extends Location{

    private Player player;
    private QuestManager questManager;
    private String questDone;


    @Override
    public String use(String command){
        if (!player.getLocation().findItem(command).getId().equals("item_bag_of_coal")){
            return null;
        }
        player.getInventory().remove(player.getLocation().findItem(command));
        questManager.setBoilerQuest(true);
        return questDone;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setQuestManager(QuestManager questManager) {
        this.questManager = questManager;
    }
}
