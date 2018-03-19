package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DirectionTest {
    private List<Boolean> rowOfSteps;
    private Point point;

    @Before
    public void setUp() throws Exception {
        rowOfSteps = Arrays.asList(false, true, false, false, true);
    }

    @Test
    public void goDown() {
        point = new Point(rowOfSteps, 3);
        Direction direction = Direction.goDown();
        assertEquals(false, direction.isLeft());
        assertEquals(false, direction.isRight());
    }

    @Test
    public void toTheLeft() {
        point = new Point(rowOfSteps, 2);
        Direction direction = Direction.toTheLeft();
        assertEquals(true, direction.isLeft());
        assertEquals(false, direction.isRight());
    }

    @Test
    public void toTheRight() {
        point = new Point(rowOfSteps, 1);
        Direction direction = Direction.toTheRight();
        assertEquals(false, direction.isLeft());
        assertEquals(true, direction.isRight());
    }
}