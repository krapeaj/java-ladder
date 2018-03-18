package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DirectionTest {
    private List<Boolean> rowOfSteps;

    @Before
    public void setUp() throws Exception {
        rowOfSteps = Arrays.asList(false, true, false, false, true);
    }

    @Test
    public void newInstanceLeftEnd() {
        Direction direction = Direction.newInstance(rowOfSteps, 0);
        assertEquals(false, direction.isLeft());
    }

    @Test
    public void newInstanceRightEnd() {
        Direction direction = Direction.newInstance(rowOfSteps, 5);
        assertEquals(true, direction.isLeft());
    }

    @Test
    public void newInstanceMiddle() {
        Direction direction = Direction.newInstance(rowOfSteps, 3);
        assertEquals(false, direction.isLeft());
        assertEquals(false, direction.isRight()); //if neither isLeft nor isRight, then direction is "down"
    }
}