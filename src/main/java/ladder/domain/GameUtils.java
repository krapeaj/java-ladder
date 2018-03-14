package ladder.domain;

import java.util.Random;

public class GameUtils {
    private static final int CHAR_LIMIT = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MIN_HEIGHT = 2;

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

    public static Boolean generateRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static boolean isOverCharLimit(String names){
        String[] splitNames = names.split(",");
        for(String name : splitNames){
            if(name.length() > CHAR_LIMIT){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEnoughNames(String names){
        String[] splitNames = names.split(",");
        return splitNames.length < MIN_NUMBER_OF_NAMES;
    }

    public static boolean isUnderMinHeight(int userInput) {
        return userInput <= MIN_HEIGHT;
    }
}