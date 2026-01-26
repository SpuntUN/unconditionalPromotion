package Console;

import Commands.Command;
import Commands.Move;
import Locations.Ship;
import Rest.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private GameState gameState;
    private GameData gameData;
    private HashMap<String, Command> commands;
    private Ship ship;
    private Player player;
    private QuestManager questManager;
    private Scanner sc;
    private boolean shouldExit;

    public void start(){
        initialization();
    }

    public void initialization(){
        sc = new Scanner(System.in);
        shouldExit = false;
        player = new Player();
        commands = new HashMap<>();
        gameData = GameData.loadGameDataFromResources("/gamedata.json");
        commands.put("move", new Move(player, gameData.locations));

    }

    private void gameLoop(){
        System.out.println(">>");
        String command = sc.next();
        String[] parts = command.split(" ");
        for (String key : commands.keySet()){
            if (!parts[0].equalsIgnoreCase(key)){
                continue;
            }
            commands.get(parts[0]).execute(command);
            shouldExit = commands.get(parts[0]).exit();
        }

    }



}
