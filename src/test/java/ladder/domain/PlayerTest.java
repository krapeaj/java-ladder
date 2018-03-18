package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() throws Exception {
        int position = 1;
        player = new Player("Jae", position);
    }

    @Test
    public void changePositionMinus() {
        assertEquals(0, player.changePosition("left"));
    }

    @Test
    public void changePositionPlus() {
        assertEquals(2, player.changePosition("right"));
    }

    @Test
    public void changePositionNoChange() {
        assertEquals(1, player.changePosition("down"));
    }
}