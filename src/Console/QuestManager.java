package Console;

public class QuestManager {
    private boolean boilerQuest;
    private boolean hullQuest;
    private boolean coordQuest;


    public QuestManager() {
        this.boilerQuest = false;
        this.hullQuest = false;
        this.coordQuest = false;
    }

    public void setBoilerQuest(boolean boilerQuest) {
        this.boilerQuest = boilerQuest;
    }

    public void setHullQuest(boolean hullQuest) {
        this.hullQuest = hullQuest;
    }

    public void setCoordQuest(boolean coordQuest) {
        this.coordQuest = coordQuest;
    }
}
