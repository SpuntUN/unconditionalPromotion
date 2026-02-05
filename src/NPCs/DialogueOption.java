package NPCs;

public class DialogueOption {
    private String text;
    private Dialogue nextDialogue;


    public String getText() {
        return text;
    }

    public Dialogue getNextDialogue() {
        return nextDialogue;
    }
}
