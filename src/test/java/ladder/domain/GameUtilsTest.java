package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameUtilsTest {
    private List<Player> players;
    private List<Prize> prizes;

    @Before
    public void setUp() throws Exception {
        players = Arrays.asList(
                new Player("Jae", 0),
                new Player("Pobi", 1),
                new Player("Hi", 3));
        prizes = Arrays.asList(
                new Prize("one"),
                new Prize("two"),
                new Prize("three")); //max length = 5
    }

    @Test
    public void findMaxNameLength() {
        assertEquals(5, GameUtils.findMaxNameLength(players, prizes));
    }

    @Test
    public void formatName() {
        assertEquals("    ", GameUtils.formatName(players.get(2), 5));
        assertEquals("   ", GameUtils.formatName(players.get(2), 4));
    }

    @Test
    public void formatRow() {
        assertEquals("     ", GameUtils.formatRow(5));
        assertEquals("  ", GameUtils.formatRow(2));
    }

    @Test
    public void formatStep() {
        assertEquals("-----", GameUtils.formatStep(5));
        assertEquals("---", GameUtils.formatStep(3));
    }

    @Test
    public void formatSpace() {
        assertEquals("   ", GameUtils.formatSpace(3));
        assertEquals("     ", GameUtils.formatSpace(5));
    }
}