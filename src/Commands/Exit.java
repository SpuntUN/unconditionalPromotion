package Commands;

public class Exit extends Command {
    @Override
    public String execute(String command) {
        return "exiting...";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
