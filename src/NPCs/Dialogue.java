package NPCs;
import java.util.ArrayList;

public class Dialogue {
    private String intro;
    private ArrayList<DialogueOption> options;



    public String displayOptions(){
        String str = intro + "\n";
        for (int i = 0; i < options.size(); i++) {
            str += (i + 1) + ". " + options.get(i).getText() + "\n";
        }
        return str;
    }

    public Dialogue chooseOption(int index) {
        if (index < 1 || index > options.size()) {
            return this;
        }
        return options.get(index - 1).getNextDialogue();
    }

    public String getIntro() {
        return intro;
    }
}
