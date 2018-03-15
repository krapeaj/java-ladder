package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static ladder.domain.LadderFormat.*;

public class LadderFormatTest {
    private StringBuilder builder;
    private LadderDTO dto;

    @Before
    public void setUp() {
        dto.setBuilder(builder);
    }

    @Test
    public void formatNameStringMax5() {
        assertEquals("   ", formatName(dto, "Jae"));
    }

    @Test
    public void formatNameStringMax3() {
        assertEquals(" ", formatName(dto, "Jae"));
    }

    @Test
    public void formatRowMax5() {
        assertEquals("     ", formatRow(dto));
    }

    @Test
    public void formatRowMax3() {
        assertEquals("   ", formatRow(dto));
    }

    @Test
    public void formatStepStringMax5() {
        assertEquals("-----", formatStepString(dto));
    }

    @Test
    public void formatStepStringMax3() {
        assertEquals("---", formatStepString(dto));
    }

    @Test
    public void formatSpaceStringMax5() {
        assertEquals("     ", formatSpaceString(dto));
    }

    @Test
    public void formatSpaceStringMax3() {
        assertEquals("   ", formatSpaceString(dto));
    }
}