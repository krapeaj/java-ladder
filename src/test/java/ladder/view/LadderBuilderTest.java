package ladder.view;

import ladder.domain.Player;
import ladder.domain.Prize;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LadderBuilderTest {
    private LadderBuilder ladderBuilder;
    private List<Player> players = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        ladderBuilder = new LadderBuilder();
    }

    @Test
    public void createLineOfUserInputPlayerNames() {
        players = Arrays.asList(new Player("Pobi", 0),
                new Player("Honux", 1),
                new Player("Hi", 2));
        assertEquals("  Pobi Honux    Hi\n", ladderBuilder.createLineOfUserInput(players, 5));
    }

    @Test
    public void createLineOfUserInputPrizeNames() {
        prizes = Arrays.asList(new Prize("Hi"),
                new Prize("Hello"),
                new Prize("Sup"));
        assertEquals("    Hi Hello   Sup\n", ladderBuilder.createLineOfUserInput(prizes, 5));
    }

    @Test
    public void createLadderPartIsStep() {
        assertEquals("|-----", ladderBuilder.createLadderPart(true, 5));
        assertEquals("|--", ladderBuilder.createLadderPart(true, 2));
    }

    @Test
    public void createLadderPartIsNotStep() {
        assertEquals("|     ", ladderBuilder.createLadderPart(false, 5));
        assertEquals("|  ", ladderBuilder.createLadderPart(false, 2));
    }
}