package Commands;

import Rest.Player;

public class Use extends Command {

    private Player player;

    public Use(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String command) {
        return player.getLocation().use(command);
    }
}
