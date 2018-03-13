package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderBuilderTest {
    LadderBuilder builder;
    String[] names;


    @Before
    public void setUp() {
        names = new String[]{"Hello", "Jae Park"};
        builder = new LadderBuilder(names);
    }

    @Test
    public void buildLadderString() {
        String nameLine = builder.addNamesToString(names).toString();
        assertEquals("    Hello Jae Park", nameLine);
    }

}