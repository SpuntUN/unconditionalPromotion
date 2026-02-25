package Commands;

import java.io.*;

/**
 * The Help class provides a command that displays helpful information
 * loaded from an external text file. This information is returned when
 * the command is executed.
 */
public class Help extends Command {

    String helpStr;


    /**
     * Loads help information from a txt file and saves it to helpStr.
     * @author Matěj Švec
     */
    public Help() {
        helpStr = "";
        InputStream input = Help.class.getResourceAsStream("/help.txt");
        if(input == null){
            throw new RuntimeException("There is a problem with loading /help.txt");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
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
