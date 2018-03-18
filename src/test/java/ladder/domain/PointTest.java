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
    public void giveDirectionLeftEnd() {
        point = new Point(rowOfSteps, 0);
        assertEquals(1, point.assignNextIndex());
    }

    @Test
    public void giveDirectionRightEnd() {
        point = new Point(rowOfSteps, 5);
        assertEquals(5, point.assignNextIndex());
    }

    @Test
    public void giveDirectionMiddle() {
        point = new Point(rowOfSteps, 2);
        assertEquals(2, point.assignNextIndex());
    }
}