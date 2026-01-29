package Commands;

import Rest.Player;

public class Look extends Command{

    Player player;

    public Look(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String command) {
        if (command.isEmpty()){
            return player.getLocation().getDescription();
        }
        return "You can't find anything like \"" + command + "\" to look at";
    }

    @Override
    public boolean exit() {
        return super.exit();
    }
}
