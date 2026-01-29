package Console;

import Commands.Command;
import Commands.Move;
import Rest.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private GameState gameState;
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

    public void initialization(){
        sc = new Scanner(System.in);
        shouldExit = false;
        player = new Player();
        commands = new HashMap<>();
        gameData = GameData.loadGameDataFromResources("/gamedata.json");
        player.setLocation(gameData.findLocation("location_bridge"));
        commands.put("move", new Move(player, gameData.locations));

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



}
