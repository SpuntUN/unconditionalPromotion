package Commands;

/**
 * According to the Commands design pattern.
 */
public abstract class Command {
    public String execute(String command){
        return "";
    }

    public boolean exit(){
        return false;
    }
}
