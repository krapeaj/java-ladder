package ladder;

import ladder.domain.GameUtils;
import ladder.domain.LadderGame;
import ladder.view.Input;
import ladder.view.Output;

public class LadderGameConsole {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        String playerNames = promptUserForNames();
        String prizes = promptUserForPrizes();
        int ladderHeight = promptUserForLadderHeight();

        //initialize game
        LadderGame ladderGame = new LadderGame(playerNames, prizes, ladderHeight);

        //String ladder = ladderGame.startBuild();
        Output.printLadder(ladderGame);
        Output.printLadder(ladderGame)
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
}