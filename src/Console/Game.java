package Console;

import Commands.*;
import Locations.Location;
import NPCs.NPC;
import Rest.Player;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The game runs here.
 * Input and console is handled here.
 * @author Matěj Švec
 */

public class Game {
    private GameData gameData;
    private HashMap<String, Command> commands;
    private Player player;
    private QuestManager questManager;
    private Scanner sc;
    private boolean shouldExit;
    public static Status status;

    public void start(){
        initialization();
        while (!shouldExit){
            gameLoop();
        }
    }

    /**
     * Checks for user input and if it corresponds to available commands, until user inputs 'exit'
     * and checks for status of the game.
     */
    private void gameLoop(){
        System.out.print(">>");
        String command = sc.nextLine().toLowerCase();
        String[] parts = command.split(" ");

        if (commands.containsKey(parts[0])) {
            System.out.println(commands.get(parts[0]).execute(command.replace(parts[0], "").trim()));
            shouldExit = commands.get(parts[0]).exit();
        } else {
            System.out.println("Unknown command: " + parts[0]);
        }

        if (status.equals(Status.DIED)){
            System.out.println("YOU DIE.");
            shouldExit = true;
        }

    }


    private void initialization(){
        status = Status.NORMAL;
        sc = new Scanner(System.in);
        shouldExit = false;
        player = new Player();

        gameData = GameData.loadGameDataFromResources("/gamedata.json");
        player.setLocation(gameData.findLocation("location_canteen"));
        neighboursInit();
        commandInit();
    }

    /**
     * Initiations neighbours of all locations and NPCs starting location.
     * NPCs starting locations
     * @author Matěj Švec
     */
    private void neighboursInit(){
        gameData.airlock.setPlayer(player);
        gameData.airlock.setQuestManager(questManager);
        gameData.airlock.setOpenedLocations(gameData.airlock.getNeighbours());
        gameData.airlock.getNeighbours().remove(gameData.findLocation("location_ext_airlock"));
        gameData.airlock.setClosedLocations(gameData.airlock.getNeighbours());
        gameData.locations.add(gameData.airlock);

        gameData.boiler.setPlayer(player);
        gameData.boiler.setQuestManager(questManager);
        gameData.locations.add(gameData.boiler);

        gameData.bridge.setQuestManager(questManager);
        gameData.bridge.setSc(sc);
        gameData.locations.add(gameData.bridge);

        for (Location l : gameData.locations){
            for (String neighbourId : l.getNeighboursId()){
                l.addNeighbour(gameData.findLocation(neighbourId));
            }
        }
        for (NPC npc : gameData.NPCs){
            npc.setLocation(gameData.findLocation(npc.getLocationId()));
        }
    }

    private void commandInit(){
        commands = new HashMap<>();
        commands.put("move", new Move(player));
        commands.put("take", new Take(player));
        commands.put("look", new Look(player, gameData.NPCs));
        commands.put("inventory", new InventoryCmd(player));
        commands.put("exit", new Exit());
        commands.put("help", new Help());
        commands.put("relinquish", new Relinquish(player));
        commands.put("talk", new Talk(player, gameData.NPCs, sc));
        commands.put("use", new Use(player));
    }







}
