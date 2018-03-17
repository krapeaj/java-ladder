package ladder.domain;

import java.util.List;
import java.util.Random;

public class GameUtils {

    public static int findMaxNameLength(List<Player> players, List<Prize> prizes) {
        int currentMax = 0;
        for (Player player : players) {
            currentMax = compareLength(player.getName(), currentMax);
        }
        for (Prize prize : prizes) {
            currentMax = compareLength(prize.getName(), currentMax);
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

    public static <T extends Item> String formatName(T item, int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength - item.getName().length() + 1; i++) {
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

    public static String formatStep(int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            formatBuilder.append("-");
        }
        return formatBuilder.toString();
    }

    public static String formatSpace(int maxNameLength) {
        StringBuilder formatBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            formatBuilder.append(" ");
        }
        return formatBuilder.toString();
    }
}