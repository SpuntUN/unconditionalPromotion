package Locations;

import Rest.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LocationTest {

    private Location loc;
    private Location neighbour1;
    private Location neighbour2;
    private Item item1;
    private Item item2;


    @Before
    public void setUp() throws Exception {
        loc = new Location("locA");
        neighbour1 = new Location("locB");
        neighbour2 = new Location("LocC");
        item1 = new Item();
        item1.setName("itemA");
        item2 = new Item();
        item2.setName("itemB");
        loc.addItem(item1);
        loc.addNeighbour(neighbour1);
        loc.addNeighbour(neighbour2);
    }

    @Test
    public void findNeighbour() {
        assertSame(neighbour1, loc.findNeighbour("locB"));
        assertSame(null, loc.findNeighbour("locE"));
    }

    @Test
    public void findItem() {
        assertSame(item1, loc.findItem("itemA"));
        assertSame(null, loc.findItem("itemC"));
    }

    @Test
    public void addItem() {
        assertEquals(true, loc.addItem(item2));
    }
}