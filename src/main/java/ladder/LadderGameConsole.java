package ladder;

import ladder.domain.GameUtils;
import ladder.domain.LadderGame;
import ladder.view.Input;
import ladder.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGameConsole {

    public static void main(String[] args) {
        LadderGame ladderGame = startGame();

        Map<String, String> result = ladderGame.generateResult();

        showResult(result);
    }

    private static LadderGame startGame() {
        String playerNames = promptUserForNames();
        String prizes = promptUserForPrizes();
        int ladderHeight = promptUserForLadderHeight();

        //initialize game
        LadderGame ladderGame = new LadderGame(playerNames, prizes, ladderHeight);

        Output.printLadder(ladderGame);

        return ladderGame;
    }

    private static String promptUserForNames() {
        Output.askForPlayerNames();
        String names = Input.takeNames();

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

    private static String promptUserForPrizes() {
        Output.askForPrizes();
        String prizes = Input.takePrizes();

        if (GameUtils.isNotEnoughNames(prizes)) {
            Output.printNotEnoughNames();
            return promptUserForNames();
        }
        if (GameUtils.isOverCharLimit(prizes)) {
            Output.printOverMaxChars();
            return promptUserForNames();
        }
        return prizes;
    }

    private static int promptUserForLadderHeight() {
        Output.askForLadderHeight();
        int ladderHeight = Input.takeHeight();
        if (GameUtils.isUnderMinHeight(ladderHeight)) {
            Output.printUnderMinHeight();
            return promptUserForLadderHeight();
        }
        return ladderHeight;
    }

    private static void showResult(Map<String, String> result) {
        String name = "";
        while(!name.equals("all")){
            name = promptUserForResultName(result);
            Output.printSelectedResult(result, name);
        }
        Output.printAllResult(result);
    }

    private static String promptUserForResultName(Map<String, String> result) {
        Output.askForResultName();
        String name = Input.takeNames();
        if(name.split(",\\s*").length != 1){
            Output.printMoreThanOneName();
            return promptUserForResultName(result);
        }
        matchName(result, name);
        return name;
    }

    private static String matchName(Map<String, String> result, String name) {
        if (result.keySet().contains(name)) {
            return name;
        }
        Output.printNameDoesNotExist(name);
        return promptUserForResultName(result);
    }
}