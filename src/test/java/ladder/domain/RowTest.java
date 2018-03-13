package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RowTest {
    private Row row;
    private ArrayList<Boolean> booleanRow;

    @Before
    public void setUp() throws Exception {
        row = new Row(10);
    }

    @Test
    public void isStep() {
        booleanRow = row.getRow();
        assertEquals(booleanRow.get(5), row.isStep(5));
    }
}