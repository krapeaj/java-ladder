package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PointTest {
    private Point point;
    private List<Boolean> rowOfSteps = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        rowOfSteps = Arrays.asList(true, false, false, true, false);
    }

    @Test
    public void stepIsOnTheLeftOnLeftEnd() {
        point = new Point(rowOfSteps, 0);
        assertEquals(false, point.stepIsOnTheLeft(rowOfSteps));
    }

    @Test
    public void stepIsOnTheLeftNotOnLeftEnd() {
        point = new Point(rowOfSteps, 1);
        assertEquals(true, point.stepIsOnTheLeft(rowOfSteps));
    }

    @Test
    public void stepIsOnTheRightOnRightEnd() {
        point = new Point(rowOfSteps, 5);
        assertEquals(false, point.stepIsOnTheRight(rowOfSteps));
    }

    @Test
    public void stepIsOnTheRightNotOnRightEnd() {
        point = new Point(rowOfSteps, 3);
        assertEquals(true, point.stepIsOnTheRight(rowOfSteps));
    }

    @Test
    public void assignNextIndexIncrease() {
        point = new Point(rowOfSteps, 3);
        assertEquals(4, point.assignNextIndex());
    }

    @Test
    public void assignNextIndexDecrease() {
        point = new Point(rowOfSteps, 4);
        assertEquals(3, point.assignNextIndex());
    }
}