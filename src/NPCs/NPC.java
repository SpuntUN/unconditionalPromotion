package NPCs;

import Locations.Location;

public class NPC {
    private String id;
    private String name;
    private String description;
    private String locationId;
    private Location location;
    private boolean canMove;
    private Dialogue dialogue;

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationId() {
        return locationId;
    }

    public Dialogue getDialogue() {
        return dialogue;
    }
}
