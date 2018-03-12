package ladder.game;

import java.util.Random;

public class GameUtils {

    public static int findMaxNameLength(String[] playerNames) {
        int currentMax = 0;
        for (String name : playerNames) {
            currentMax = compareLength(name, currentMax);
        }
        return currentMax;
    }

    private static int compareLength(String name, int currentMax) {
        if (name.length() <= currentMax) {
            return currentMax;
        }
        return name.length();
    }

    public static Boolean generateRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
