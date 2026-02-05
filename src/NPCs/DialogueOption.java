package NPCs;

import Rest.Player;

public class DialogueOption {
    private String text;
    private Dialogue nextDialogue;
    private String requiredItemId;

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
