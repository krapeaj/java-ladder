package ladder.domain;

import ladder.view.Input;
import ladder.view.Output;

import java.util.Map;

public class UserPrompt {
    private static final int CHAR_LIMIT = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MIN_HEIGHT = 2;

    public static String[] promptUserForNames() {
        Output.askForPlayerNames();
        String[] names = Input.takeNames().split(",\\s*");
        if (isNotEnoughNames(names)) {
            Output.printNotEnoughNames();
            return promptUserForNames();
        }
        if (isOverCharLimit(names)) {
            Output.printOverMaxChars();
            return promptUserForNames();
        }
        return names;
    }

    public static String[] promptUserForPrizes(String[] names) {
        Output.askForPrizes();
        String[] prizes = Input.takePrizes().split(",\\s*");
        if (isNotEqualToNumberOfPlayers(prizes.length, names.length)) {
            Output.printNotEqualNumbers();
            return promptUserForPrizes(names);
        }
        if (isOverCharLimit(prizes)) {
            Output.printOverMaxChars();
            return promptUserForPrizes(names);
        }
        return prizes;
    }

    public static int promptUserForLadderHeight() {
        Output.askForLadderHeight();
        int ladderHeight = Input.takeHeight();
        if (isUnderMinHeight(ladderHeight)) {
            Output.printUnderMinHeight();
            return promptUserForLadderHeight();
        }
        return ladderHeight;
    }

    private static boolean isOverCharLimit(String[] names) {
        for (String name : names) {
            if (name.length() > CHAR_LIMIT) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotEnoughNames(String[] names) {
        return names.length < MIN_NUMBER_OF_NAMES;
    }

    private static boolean isNotEqualToNumberOfPlayers(int numberOfPrizes, int numberOfPlayers) {
        return numberOfPrizes != numberOfPlayers;
    }

    private static boolean isUnderMinHeight(int userInput) {
        return userInput <= MIN_HEIGHT;
    }

    public static String promptUserForResultName(Map<String, String> result) {
        Output.askForResultName();
        String name = Input.takeNames();
        if (isExit(name)) {
            return name;
        }
        if (name.split(",\\s*").length == 1 && inNames(result, name)) {
            return name;
        }
        Output.printMoreThanOneName();
        return promptUserForResultName(result);
    }

    private static boolean inNames(Map<String, String> result, String name) {
        if (result.keySet().contains(name)) {
            return true;
        }
        Output.printNameDoesNotExist(name);
        return false;
    }

    public static boolean isExit(String name) {
        return name.equals("all") || name.equals("x");
    }
}