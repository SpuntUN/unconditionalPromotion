package Commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Help class provides a command that displays helpful information
 * loaded from an external text file. This information is returned when
 * the command is executed.
 */
public class Help extends Command {

    String helpStr;


    /**
     * Loads help information from a txt file and saves it to helpStr.
     */
    public Help() {
        helpStr = "";
        try (BufferedReader br = new BufferedReader(new FileReader("res/help.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                helpStr += line + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String execute(String command) {
        return helpStr;
    }

}
