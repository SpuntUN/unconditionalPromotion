package Commands;

public abstract class Command {
    public String execute(String command){
        return "";
    }

    public boolean exit(){
        return false;
    }
}
