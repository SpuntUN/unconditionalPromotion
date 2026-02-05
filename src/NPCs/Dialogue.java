package NPCs;
import Rest.Player;

import java.util.ArrayList;

public class Dialogue {
    private String intro;
    private ArrayList<DialogueOption> options;



    public String displayOptions(Player player) {
        String str = intro + "\n";
        int visibleIndex = 1;

        for (DialogueOption option : options) {
            if (option.isAvailable(player)) {
                str += visibleIndex + ". " + option.getText() + "\n";
                visibleIndex++;
            }
        }
        return str;
    }

    public Dialogue chooseOption(int index, Player player) {
        int visibleIndex = 1;

        for (DialogueOption option : options) {
            if (option.isAvailable(player)) {
                if (visibleIndex == index) {
                    return option.getNextDialogue();
                }
                visibleIndex++;
            }
        }
        return this;
    }

    public String getIntro() {
        return intro;
    }
}
