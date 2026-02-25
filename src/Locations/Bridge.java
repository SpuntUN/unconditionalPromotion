package Locations;

import Console.QuestManager;

import java.util.Scanner;

public class Bridge extends Location{

    private boolean locked;
    private QuestManager questManager;
    private Scanner sc;
    private String note;

    @Override
    public String use(String command) {
        return switch (command) {
            case "note" -> note;
            case "computer" -> Computer();
            default -> null;
        };
    }

    private String Computer(){
        System.out.println("Welcome Captain:\n1)Fly Home\n2)Coordinates");
        System.out.println(">>");
        return switch (sc.nextLine()) {
            case "1" -> flyHome();
            case "2" -> coordinates();
            default -> "Unregistered command, logging out...";
        };
    }

    private String flyHome(){

    }

    private String coordinates(){

    }

    public void setQuestManager(QuestManager questManager) {
        this.questManager = questManager;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
