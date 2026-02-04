package Console;

import Commands.Command;
import Commands.Look;
import Commands.Move;
import Commands.Take;
import Locations.Location;
import Rest.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private GameData gameData;
    private HashMap<String, Command> commands;
    private Player player;
    private QuestManager questManager;
    private Scanner sc;
    private boolean shouldExit;

    public void start(){
        initialization();
        while (!shouldExit){
            gameLoop();
        }
    }

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

    }

    private void initialization(){
        sc = new Scanner(System.in);
        shouldExit = false;
        player = new Player();

        gameData = GameData.loadGameDataFromResources("/gamedata.json");
        player.setLocation(gameData.findLocation("location_bridge"));
        neighboursSet();
        commandInit();
    }

    private void neighboursSet(){
        for (Location l : gameData.locations){
            for (String neighbourId : l.getNeighboursId()){
                l.addNeighbour(gameData.findLocation(neighbourId));
            }
            for (String itemId : l.getStoredId()){
                l.addStored(gameData.findItem(itemId));
            }
        }
    }

    private void commandInit(){
        commands = new HashMap<>();
        commands.put("move", new Move(player, gameData.locations));
        commands.put("take", new Take(player, gameData.items));
        commands.put("look", new Look(player));
    }







}
