package Commands;

import Locations.Location;
import Rest.Item;
import Rest.Player;
import junit.framework.TestCase;

public class RelinquishTest extends TestCase {

    private Player player;
    private Relinquish relinquish;
    private Item item;
    private Location loc;

    public void setUp() throws Exception {
        player = new Player();
        item = new Item();
        item.setName("Lar");
        loc = new Location("a");
        player.setLocation(loc);
        player.getInventory().add(item);
        relinquish = new Relinquish(player);
    }

    public void testExecute() {
        relinquish.execute("lar");
        assertNull(player.getInventory().findItem("lar"));
        assertSame(item, player.getLocation().findItem("lar"));
    }
}
