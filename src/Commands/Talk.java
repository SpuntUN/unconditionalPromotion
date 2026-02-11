package Commands;

import NPCs.Dialogue;
import NPCs.NPC;
import Rest.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Talk extends Command{

    private Player player;
    private ArrayList<NPC> NPCs;
    private Scanner sc;
    private Dialogue currentDialogue;


    public Talk(Player player, ArrayList<NPC> NPCs, Scanner sc) {
        this.player = player;
        this.NPCs = NPCs;
        this.sc = sc;
        currentDialogue = null;
    }

    /**
     * Initiations dialogue with an NPC located at the player's current location.
     * The method searches for an NPC at the player's location, validates if the NPC is capable of dialogue,
     * and proceeds to interact with the NPC through dialogue options until the conversation ends.
     *
     * @param command the name of the NPC to engage in dialogue.
     * @return a message indicating the result of the conversation, such as whether the NPC was found,
     *         whether they can talk, or the conclusion of the dialogue interaction.
     */

    @Override
    public String execute(String command) {
        NPC npc = null;
        for (NPC n : NPCs){
            if (n.getLocation().equals(player.getLocation())){
                npc = n;
                break;
            }
        }
        if (npc == null){
            return "No person with the name \"" + command + "\" has been found";
        }
        if (npc.getDialogue() == null){
            return "They can't talk";
        }


        currentDialogue = npc.getDialogue();
        boolean doneTalking = false;
        while (!doneTalking){
            System.out.println(currentDialogue.displayOptions(player));

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
                continue;
            }

            currentDialogue = currentDialogue.chooseOption(choice, player);
            if (currentDialogue == null){
                doneTalking = true;
            }
        }
        return "You stop talking";
    }

}
