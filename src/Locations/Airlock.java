package Locations;

import Console.Game;
import Console.QuestManager;
import Console.Status;
import Rest.Player;

import java.util.ArrayList;

public class Airlock extends Location{

    private Player player;
    private boolean decompressed;
    private boolean doorOpen;
    private String lever_NoSuitDeath;
    private String lever_CompressionWhileDoorOpenedDeath;
    private String lever_Decompress;
    private String lever_Compress;
    private String door_Close;
    private String door_CompressedFlungWithoutSuitDeath;
    private String door_CompressedFlungWithSuitDeath;
    private String door_Open;
    private Location exterior;
    private QuestManager questManager;



    public Airlock(String name) {
        super(name);
        decompressed = false;
        doorOpen = false;
    }

    @Override
    public String use(String command) {
        if (!questManager.isHullOngoing()){
            return "No need to use anything in here now";
        }
        return switch (command) {
            case "lever" -> pullLever();
            case "button" -> pushButton();
            default -> null;
        };
    }


    /**
     * Triggers the lever's functionality depending on if the player has a suit on,
     * the room is decompressed and or the door.
     * Can result in death, which is than handled in Class Game.
     * @return String informing the player of successfully decompression or compression; or a successful death.
     */
    private String pullLever(){
        if (!hasSpaceSuit()){
            Game.status = Status.DIED;
            return lever_NoSuitDeath;
        }
        if (!decompressed){
            decompressed = true;
            return lever_Decompress;
        }
        if (doorOpen){
            Game.status = Status.DIED;
            return lever_CompressionWhileDoorOpenedDeath;
        }
        decompressed = false;
        return lever_Compress;
    }

    /**
     * Triggers the button's functionality depending on if the player has a suit on,
     * the room is decompressed and or the door.
     * Can result in death, which is than handled in Class Game.
     * @return String informing the player of successfully opening or closing of the door; or a successful death.
     */
    private String pushButton(){
        if (doorOpen){
            doorOpen = false;
            removeExterior();
            return door_Close;
        }
        if (!hasSpaceSuit()){
            Game.status = Status.DIED;
            return door_CompressedFlungWithoutSuitDeath;
        }
        if (!decompressed){
            Game.status = Status.DIED;
            return door_CompressedFlungWithSuitDeath;
        }
        doorOpen = true;
        addExterior();
        return door_Open;
    }

    private void addExterior(){
        neighbours.add(exterior);
    }

    private void removeExterior(){
        neighbours.remove(exterior);
    }

    private boolean hasSpaceSuit(){
        return player.getInventory().findItem("space suit") != null;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setExterior(Location exterior) {
        this.exterior = exterior;
    }

    public void setQuestManager(QuestManager questManager) {
        this.questManager = questManager;
    }
}


