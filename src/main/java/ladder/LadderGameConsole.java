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
        int ladderHeight = promptUserForLadderHeight();
        LadderGame ladderGame = new LadderGame(playerNames, ladderHeight);

        String ladderString = ladderGame.startBuild();
        ladderGame.displayLadder(ladderString);
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