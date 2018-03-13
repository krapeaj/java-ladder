package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderBuilderTest {
    private Row row;
    private String[] names;

    @Before
    public void setUp() {
        row = new Row(3);
        names = new String[]{"Colin", "Jae", "Pobi"};
    }

    @Test
    public void addNamesToString() {
        int maxNameLength = "Colin".length();
        assertEquals(" Colin   Jae  Pobi", LadderBuilder.addNamesToString(names, maxNameLength));
    }
}