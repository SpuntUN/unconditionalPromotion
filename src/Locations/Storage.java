package Locations;

import Rest.Player;

public class Storage extends Location{

    private Player player;
    private String gotCoal;
    private boolean done;

    /**
     * @param command user set command, it is being checked if it is a crowbar.
     * @return Either a message of putting coal in a boiler or that nothing happened (null)
     */
    @Override
    public String use(String command) {
        if (command.equals("crowbar") && player.getInventory().findItem("crowbar") != null && !done){
            done = true;
            player.getInventory().remove(player.getInventory().findItem("crowbar"));
            player.getInventory().add(findItem("coal"));
            return gotCoal;
        }
        return null;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
