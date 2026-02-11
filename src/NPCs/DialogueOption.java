package NPCs;

import Rest.Player;

/**
 * A specific option in a dialogue tree.
 * Consist of a text which displays what the player would say, next dialogue tree if chosen,
 * and if this option requires an item to appear.
 * @author Matěj Švec
 */

public class DialogueOption {
    private String text;
    private Dialogue nextDialogue;
    private String requiredItemId;

    /**
     * Checks if player has a required item for this option to appear.
     * @param player whose inventory is being checked.
     * @return true if it should appear and false if not.
     * @author Matěj Švec
     */
    public boolean isAvailable(Player player) {
        if (requiredItemId == null) return true;
        return player.getInventory().findItem(requiredItemId) != null;
    }


    public String getText() {
        return text;
    }

    public Dialogue getNextDialogue() {
        return nextDialogue;
    }
}
