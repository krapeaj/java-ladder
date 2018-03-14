package ladder;

import ladder.domain.GameUtils;
import ladder.domain.LadderGame;
import ladder.view.Input;
import ladder.view.Output;

import java.util.InputMismatchException;

public class LadderGameConsole {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        String playerNames = promptUserForNames();
        int ladderHeight = promptUserForLadderHeight();
        LadderGame ladderGame = new LadderGame(playerNames, ladderHeight);

        String ladderString = ladderGame.buildLadder();
        ladderGame.displayLadder(ladderString);
    }

    private static String promptUserForNames() {
        Output.askForPlayerNames();
        String names = Input.takeString();

        if(GameUtils.isNotEnoughNames(names)){
            Output.printNotEnoughNames();
            return promptUserForNames();
        }
        if(GameUtils.isOverCharLimit(names)){
            Output.printOverMaxChars();
            return promptUserForNames();
        }
        return names;
    }

    private static int promptUserForLadderHeight() {
        Output.askForLadderHeight();
        int ladderHeight = Input.takeInt();
        if(GameUtils.isUnderMinHeight(ladderHeight)){
            Output.printUnderMinHeight();
            return promptUserForLadderHeight();
        }
        return ladderHeight;
    }




}