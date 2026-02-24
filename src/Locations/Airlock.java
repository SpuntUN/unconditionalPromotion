package Locations;

import Console.Game;
import Console.Status;
import Rest.Player;

public class Airlock extends Location{

    private Player player;
    private boolean decompressed;
    private boolean doorOpen;
    private String lever_NoSuitDeath;
    private String lever_CompressionWhileDoorOpenedDeath;
    private String lever_Decompress;
    private String lever_Compress;
    private String door_Close;
    private String door_DecompressedStillWithoutSuitDeath;
    private String door_CompressedFlungWithoutSuitDeath;
    private String door_CompressedFlungWithSuitDeath;
    private String door_Open;



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


    /**
     * Triggers the lever's functionality depending on if the player has a suit on,
     * the room is decompressed and or the door.
     * Can result in death, which is than handled in Class Game.
     * @return String informing the player of successfully decompression or successful death.
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

    private String pushButton(){
        if (doorOpen){
            doorOpen = false;
            return door_Close;
        }
        if (!hasSpaceSuit()){
            Game.status = Status.DIED;
            if (decompressed){;
                return door_DecompressedStillWithoutSuitDeath;
            }
            return door_CompressedFlungWithoutSuitDeath;
        }
        if (!decompressed){
            Game.status = Status.DIED;
            return door_CompressedFlungWithSuitDeath;
        }
        doorOpen = true;
        return door_Open;
    }

    private boolean hasSpaceSuit(){
        return player.getInventory().findItem("space suit").getId().equals("item_space_suit");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}


