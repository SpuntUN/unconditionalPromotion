package NPCs;
import Rest.Player;

import java.util.ArrayList;

/**
 * Represents a conversation that a player can have.
 * It has an introductory text and a list of dialogue options, which vary
 * depending on the NPC or the player's inventory.
 * @author Matěj Švec
 */

public class Dialogue {
    private String intro;
    private ArrayList<DialogueOption> options;


    /**
     * Displays a list of dialogue options available to the player based on their current state.
     * Each available option is numbered, and the list starts with the dialogue introduction.
     *
     * @param player who is passed into option method.
     * @return a formatted string of dialogue options.
     */
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

    /**
     * Chooses and advances the dialogue to the next stage based on the player's selected option.
     *
     * @param index the index corresponding to a dialogue option, starting from 1.
     * @param player the player whose current state determines available options.
     * @return the next dialogue if the given index corresponds to an available option otherwise, returns the current dialogue.
     * @author Matěj Švec
     */
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
