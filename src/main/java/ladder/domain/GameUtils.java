package ladder.domain;

import java.util.List;
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

    public static int findMaxNameLength(List<Player> players) {
        int currentMax = 0;
        for (Player player : players) {
            currentMax = compareLength(player.getName(), currentMax);
        }
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

    public static String formatName(Player player, int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength - player.getName().length() + 1; i++) {
            formatBuilder.append(" ");
        }
        return formatBuilder.toString();
    }

    public static String formatRow(int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            formatBuilder.append(" ");
        }
        return formatBuilder.toString();
    }

    public static String formatStepString(int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            formatBuilder.append("-");
        }
        return formatBuilder.toString();
    }

    public static String formatSpaceString(int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            formatBuilder.append(" ");
        }
        return formatBuilder.toString();
    }
}