package Console;

public class QuestManager {
    private boolean boilerQuest;
    private boolean hullOngoing;
    private boolean hullQuest;
    private boolean coordOngoing;
    private boolean coordQuest;


    public QuestManager() {
        this.boilerQuest = false;
        this.hullOngoing = false;
        this.hullQuest = false;
        this.coordOngoing = false;
        this.coordQuest = false;
    }

    public void setBoilerQuest(boolean boilerQuest) {
        this.boilerQuest = boilerQuest;
    }

    public void setHullOngoing(boolean hullOngoing) {
        this.hullOngoing = hullOngoing;
    }

    public void setHullQuest(boolean hullQuest) {
        this.hullQuest = hullQuest;
    }

    public void setCoordQuest(boolean coordQuest) {
        this.coordQuest = coordQuest;
    }

    public boolean isBoilerQuest() {
        return boilerQuest;
    }

    public boolean isHullOngoing() {
        return hullOngoing;
    }

    public boolean isHullQuest() {
        return hullQuest;
    }

    public boolean isCoordQuest() {
        return coordQuest;
    }

    public boolean isCoordOngoing() {
        return coordOngoing;
    }

    public void setCoordOngoing(boolean coordOngoing) {
        this.coordOngoing = coordOngoing;
    }
}
