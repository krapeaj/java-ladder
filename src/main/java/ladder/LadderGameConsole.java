package ladder;

import ladder.domain.LadderGame;
import ladder.view.Input;
import ladder.view.Output;

import java.util.InputMismatchException;

public class LadderGameConsole {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        String playerNames = Input.promptUserForNames();
        int ladderHeight = Input.promptUserForLadderHeight();
        LadderGame ladderGame = new LadderGame(playerNames, ladderHeight);

        String ladderString = ladderGame.buildLadder();
        ladderGame.displayLadder(ladderString);
    }
}