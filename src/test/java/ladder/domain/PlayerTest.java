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
    public void changePositionDecrease() {
        assertEquals(0, player.changePosition(0));
    }

    @Test
    public void changePositionIncrease() {
        assertEquals(2, player.changePosition(2));
    }

    @Test
    public void changePositionNoChange() {
        assertEquals(1, player.changePosition(1));
    }
}