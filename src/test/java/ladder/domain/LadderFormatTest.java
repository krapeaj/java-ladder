package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderFormatTest {
    private StringBuilder builder;

    @Before
    public void setUp() {
        builder = new StringBuilder();
    }

    @Test
    public void formatNameStringMax5() {
        assertEquals("   ", LadderFormat.formatNameString("Jae", 5));
    }

    @Test
    public void formatNameStringMax3() {
        assertEquals(" ", LadderFormat.formatNameString("Jae", 3));
    }

    @Test
    public void formatRowMax5() {
        assertEquals("     ", LadderFormat.formatRow(builder, 5));
    }

    @Test
    public void formatRowMax3() {
        assertEquals("   ", LadderFormat.formatRow(builder, 3));
    }

    @Test
    public void formatStepStringMax5() {
        assertEquals("-----", LadderFormat.formatStepString(builder, 5));
    }

    @Test
    public void formatStepStringMax3() {
        assertEquals("---", LadderFormat.formatStepString(builder, 3));
    }

    @Test
    public void formatSpaceStringMax5() {
        assertEquals("     ", LadderFormat.formatSpaceString(builder, 5));
    }

    @Test
    public void formatSpaceStringMax3() {
        assertEquals("   ", LadderFormat.formatSpaceString(builder, 3));
    }
}