package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserPromptTest {
    private Map<String, String> result;

    @Before
    public void setUp() throws Exception {
        result = new LinkedHashMap<>();
    }

    @Test
    public void promptUserForNames() {
        String input = "Pobi,Honux, Crong"; //.split(",\\s*")
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] names = UserPrompt.promptUserForNames();
        assertArrayEquals(new String[]{"Pobi", "Honux", "Crong"}, names);
    }

    @Test
    public void promptUserForPrizes() {
        String input = "A,B,C";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] names = UserPrompt.promptUserForNames();
        assertArrayEquals(new String[]{"A", "B", "C"}, names);
    }

    @Test
    public void promptUserForLadderHeight() {
        String input = "100";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int height = UserPrompt.promptUserForLadderHeight();
        assertEquals(100, height);
    }

    @Test
    public void promptUserForResultName() {
        String input = "Jae";
        result.put("Pobi", "A");
        result.put("Jae", "B");
        result.put("Park", "C");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String name = UserPrompt.promptUserForResultName(result);
        assertEquals("Jae", name);
    }

    @Test
    public void inNamesTrue() {
        result.put("A", "aaa");
        result.put("B", "bbb");
        result.put("C", "ccc");
        assertEquals(true, UserPrompt.inNames(result, "A"));
        assertEquals(true, UserPrompt.inNames(result, "B"));
        assertEquals(true, UserPrompt.inNames(result, "C"));
    }

    @Test
    public void inNamesFalse() {
        result.put("A", "aaa");
        result.put("B", "bbb");
        result.put("C", "ccc");
        assertEquals(false, UserPrompt.inNames(result, "D"));
    }

    @Test
    public void isExitTrue() {
        assertEquals(true, UserPrompt.isExit("all"));
        assertEquals(true, UserPrompt.isExit("x"));
    }

    @Test
    public void isExitFalse() {
        assertEquals(false, UserPrompt.isExit(""));
        assertEquals(false, UserPrompt.isExit("exit"));
    }
}