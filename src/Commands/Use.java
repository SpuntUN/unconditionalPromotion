package Commands;

import Rest.Player;

public class Use extends Command {

    private Player player;

    public Use(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String command) {
        String response = player.getLocation().use(command);
        if (response != null){
            System.out.println("wasd");
            return response;
        }
        return "You couldn't find anything like \"" + command + "\" to use.";
    }
}
