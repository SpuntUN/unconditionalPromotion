package Console;

import Commands.Command;
import Commands.Move;
import Locations.Ship;
import Rest.Player;

import java.util.HashMap;

public class Game {
    private GameState gameState;
    private GameData gameData;
    private HashMap<String, Command> commands;
    private Ship ship;
    private Player player;
    private QuestManager questManager;

    public void start(){
        initialization();
    }

    public void initialization(){
        player = new Player();
        commands = new HashMap<>();
        gameData = GameData.loadGameDataFromResources("/gamedata.json");
        commands.put("move", new Move(player, gameData.locations));

    }

}
