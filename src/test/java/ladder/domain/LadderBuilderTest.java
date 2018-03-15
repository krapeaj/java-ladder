package ladder.domain;

import ladder.view.LadderBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderBuilderTest {
    private Row row;
    private String[] names;
    private LadderDTO dto;
    private LadderGame game;

    @Before
    public void setUp() {
        row = new Row(3);
        dto.setPlayerNames(new String[]{"Colin", "Jae", "Pobi"});
    }

    @Test
    public void addNamesToString() {
        int maxNameLength = "Colin".length();
        assertEquals(" Colin   Jae  Pobi", LadderBuilder.addNamesToBuilder(dto));
    }
}