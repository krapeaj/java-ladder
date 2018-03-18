package ladder;

import ladder.domain.LadderGame;
import ladder.domain.UserPrompt;
import ladder.view.Input;
import ladder.view.Output;

import java.util.Map;

public class LadderGameConsole {

    public static void main(String[] args) {
        LadderGame ladderGame = startGame();

        Map<String, String> result = ladderGame.generateResult();

        showResult(result);
    }

    private static LadderGame startGame() {
        String[] names = UserPrompt.promptUserForNames();
        String[] prizes = UserPrompt.promptUserForPrizes(names);
        int ladderHeight = UserPrompt.promptUserForLadderHeight();

        //initialize game
        LadderGame ladderGame = new LadderGame(names, prizes, ladderHeight); //static factory method??

        Output.printLadder(ladderGame);

        return ladderGame;
    }

    private static void showResult(Map<String, String> result) {
        String name = "";
        while (!UserPrompt.isExit(name)) {
            name = UserPrompt.promptUserForResultName(result);
            Output.printSelectedResult(result, name);
        }
        if (name.equals("all")) {
            Output.printAllResult(result);
        }
    }
}