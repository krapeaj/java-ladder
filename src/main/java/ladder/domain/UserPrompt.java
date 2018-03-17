package ladder.domain;

import ladder.view.Input;
import ladder.view.Output;

import java.util.Map;

public class UserPrompt {

    public static String[] promptUserForNames() {
        Output.askForPlayerNames();
        String[] names = Input.takeNames().split(",\\s*");

        if (GameUtils.isNotEnoughNames(names)) {
            Output.printNotEnoughNames();
            return promptUserForNames();
        }
        if (GameUtils.isOverCharLimit(names)) {
            Output.printOverMaxChars();
            return promptUserForNames();
        }
        return names;
    }

    public static String[] promptUserForPrizes(String[] names) {
        Output.askForPrizes();
        String[] prizes = Input.takePrizes().split(",\\s*");
        if (GameUtils.isNotEqualToNumberOfPlayers(prizes.length, names.length)) {
            Output.printNotEqualNumbers();
            return promptUserForPrizes(names);
        }
        if (GameUtils.isOverCharLimit(prizes)) {
            Output.printOverMaxChars();
            return promptUserForPrizes(names);
        }
        return prizes;
    }

    public static int promptUserForLadderHeight() {
        Output.askForLadderHeight();
        int ladderHeight = Input.takeHeight();
        if (GameUtils.isUnderMinHeight(ladderHeight)) {
            Output.printUnderMinHeight();
            return promptUserForLadderHeight();
        }
        return ladderHeight;
    }

    public static String promptUserForResultName(Map<String, String> result) {
        Output.askForResultName();
        String name = Input.takeNames();
        if (isExit(name)) {
            return name;
        }
        if (name.split(",\\s*").length != 1) {
            Output.printMoreThanOneName();
            return promptUserForResultName(result);
        }
        matchName(result, name);
        return name;
    }

    private static String matchName(Map<String, String> result, String name) {
        if (result.keySet().contains(name) || isExit(name)) {
            return name;
        }
        Output.printNameDoesNotExist(name);
        return promptUserForResultName(result);
    }

    public static boolean isExit(String name) {
        return name.equals("all") || name.equals("x");
    }
}
