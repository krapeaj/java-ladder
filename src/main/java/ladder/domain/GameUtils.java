package ladder.domain;

import java.util.Random;

public class GameUtils {
    private static final int CHAR_LIMIT = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MIN_HEIGHT = 2;

    public static boolean isOverCharLimit(String names) {
        String[] splitNames = names.split(",\\s*");
        for (String name : splitNames) {
            if (name.length() > CHAR_LIMIT) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEnoughNames(String names) {
        String[] splitNames = names.split(",\\s*");
        return splitNames.length < MIN_NUMBER_OF_NAMES;
    }

    public static boolean isUnderMinHeight(int userInput) {
        return userInput <= MIN_HEIGHT;
    }

    public static int findMaxNameLength(LadderDTO dto) {
        int currentMax = 0;
        for (String name : dto.getPlayerNames()) {
            currentMax = compareLength(name, currentMax);
        }
        dto.setMaxNameLength(currentMax);
        return currentMax;
    }

    private static int compareLength(String name, int currentMax) {
        if (name.length() <= currentMax) {
            return currentMax;
        }
        return name.length();
    }

    public static Boolean generateRandomBools() {
        Random random = new Random();
        return random.nextBoolean();
    }
}