package Commands;

import Rest.Player;

public class InventoryCmd extends  Command{

    private Player player;

    public InventoryCmd(Player player){
        this.player = player;
    }

    @Override
    public String execute(String command) {
        return player.getInventory().getInventoryNames();
    }

}
