package Locations;

import Console.Game;
import Console.QuestManager;
import Console.Status;

import java.util.Scanner;

public class Bridge extends Location{

    private boolean locked;
    private String password;
    private QuestManager questManager;
    private Scanner sc;
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

    private String Computer(){
        System.out.println("Password: ");
        if (!sc.nextLine().equals(password)){
            return "Wrong password, try again later...";
        }
        boolean logged = true;
        while (logged){
            System.out.println("Welcome Captain:\n1)Fly Home\n2)Set Coordinates\n3)Log out");
            System.out.println(">>");
            switch (sc.nextLine()){
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

    private void flyHome(){
        if (questManager.isBoilerQuest()){
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

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
