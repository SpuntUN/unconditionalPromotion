package Locations;

import Rest.Player;

public class Airlock extends Location{

    private Player player;
    private boolean decompressed;
    private boolean doorOpen;

    public Airlock(String name) {
        super(name);
        decompressed = false;
        doorOpen = false;
    }

    @Override
    public String use(String command) {
        return switch (command) {
            case "lever" -> pullLever();
            case "button" -> pushButton();
            default -> "You couldn't find anything like \"" + command + "\" to use.";
        };
    }

    private String pullLever(){
        if (!hasSpaceSuit()){

        }
    }

    private String pushButton(){

    }

    private boolean hasSpaceSuit(){
        return player.getInventory().findItem("space suit").getId().equals("item_space_suit");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}


