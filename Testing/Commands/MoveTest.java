package Commands;

import Locations.Location;
import Rest.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class MoveTest {

    private Player player;
    private Move move;
    private Location loc1;
    private Location loc2;


    @Before
    public void setUp() throws Exception {
        loc1 = new Location("a");
        loc2 = new Location("b");
        loc1.addNeighbour(loc2);
        loc2.addNeighbour(loc1);
        player = new Player();
        player.setLocation(loc1);
        move = new Move(player);
    }

    @Test
    public void execute() {
        move.execute("b");
        assertSame(loc2, player.getLocation());
        assertEquals("Moved to a", move.execute("a"));


    }
}