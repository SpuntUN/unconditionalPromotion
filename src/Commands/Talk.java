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


        currentDialogue = npc.getDialogue();
        boolean doneTalking = false;
        while (!doneTalking){
            System.out.println(currentDialogue.displayOptions());

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
                continue;
            }

            currentDialogue = currentDialogue.chooseOption(choice);
            if (currentDialogue == null){
                doneTalking = true;
            }
        }
        return "You stop talking";
    }

    @Override
    public boolean exit() {
        return super.exit();
    }
}
