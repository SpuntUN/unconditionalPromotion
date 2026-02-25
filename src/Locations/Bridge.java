package Locations;

import Console.Game;
import Console.QuestManager;
import Console.Status;

import java.util.Scanner;

public class Bridge extends Location{

    private boolean locked;
    private String password;
    private QuestManager questManager;
    private String noteMs;
    private String meteoroidsMs;

    @Override
    public String use(String command) {
        return switch (command) {
            case "note" -> note();
            case "computer" -> Computer();
            default -> null;
        };
    }

    /**
     * This method prompts the user for a password. Then it will ask him three questions where she chooses by number.
     * A switch statment leads to methods that decides if he wins, loses, or nothing happens.
     * @return A message indicating the outcome of the interaction. It could return:
     *         - A message indicating the password attempt was incorrect.
     *         - A confirmation message indicating successful log out or conclusion of computer interaction.
     */
    private String Computer(){
        System.out.println("Password: ");
        if (!Game.sc.nextLine().equals(password)){
            return "Wrong password, try again later...";
        }
        boolean logged = true;
        while (logged){
            System.out.println("Welcome Captain:\n1)Fly Home\n2)Set Coordinates\n3)Log out");
            System.out.println(">>");
            switch (Game.sc.nextLine()){
                case "1":
                    flyHome();
                    break;
                case "2":
                    coordinates();
                    break;
                case "3":
                    System.out.println("Logging out...");
                    logged = false;
                    break;
                default:
                    System.out.println("Try again");;
                    break;
            }
            if (Game.status == Status.WON || Game.status == Status.DIED){
                logged = false;
            }
        }
        return "You get up from the computer";
    }

    /**
     * This method decides if player can fly home and end the game.
     */
    private void flyHome(){
        if (!questManager.isBoilerQuest()){
            System.out.println("No fuel in the boiler");
            return;
        }
        if (!questManager.isHullOngoing() && !questManager.isHullQuest()){
            System.out.println(meteoroidsMs);
            questManager.setHullOngoing(true);
            return;
        }
        if (!questManager.isHullQuest()){
            System.out.println("CAN'T THRUST UNTIL DAMAGED REPAIRED");
            return;
        }
        if (questManager.isCoordQuest()){
            System.out.println("ACTIVATING THRUSTERS");
            Game.status = Status.WON;
        }else {
            System.out.println("ACTIVATING THRUSTERS\n\nWith a smile on your face you look into the distance, then you remember:\n\"I did not set the coordinates.\"");
            Game.status = Status.DIED;
        }
    }

    /**
     * This method handles setting coordinates. It interacts with the questManager.
     * - If the coordinate quest is already completed, it informs the user and exits.
     * - If the coordinate quest is ongoing, it informs the user, updates the questManager to mark
     *   the quest as completed, and sets the coordinates.
     * - If the coordinate quest is not ongoing, it informs the user that they do not have the required information
     *   to set the coordinates.
     */
    private void coordinates(){
        if (questManager.isCoordQuest()){
            System.out.println("You have already set the coordinates");
            return;
        }

        if (questManager.isCoordOngoing()){
            System.out.println("From the note you set the coordinates to Earth...");
            questManager.setCoordQuest(true);
        } else{
            System.out.println("You don't know the coordinates to Earth");
        }
    }

    public String note(){
        questManager.setCoordOngoing(true);
        return noteMs;
    }

    public void setQuestManager(QuestManager questManager) {
        this.questManager = questManager;
    }

}
