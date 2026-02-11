package Commands;

import Locations.Location;
import Rest.Item;
import Rest.Player;
import junit.framework.TestCase;

import java.util.ArrayList;

public class TakeTest extends TestCase {

    private Player player;
    private Take take;
    private Item item;
    private Location loc;

    public void setUp() throws Exception {
        player = new Player();
        item = new Item();
        take = new Take(player);
        item.setName("Lar");
        loc = new Location("a");
        loc.addItem(item);
        player.setLocation(loc);

    }

    public void testExecute() {
        take.execute("lar");
        assertSame(item, player.getInventory().findItem("lar"));
    }
}