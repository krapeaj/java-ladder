package ladder;

import ladder.domain.GameUtils;
import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.domain.Prize;
import ladder.view.Input;
import ladder.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderGameConsole {

    public static void main(String[] args) {
        LadderGame ladderGame = startGame();

        Map<Player, Prize> result = ladderGame.generateResult();


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


    private static void showResult(Map<Player, Prize> result){
        String prize = promptUserForResultNames(result);

    }

    private static String promptUserForResultNames(Map<Player, Prize> result){
        Output.askForResultNames();
        String name = Input.takeNames();
        List<String> splitNames = Arrays.asList(name.split(",\\s*"));

        for(String name : splitNames){

        }
        for(Player player : result.keySet()){

            if(existsAMatch(player, name)){
                return result.get(player).getPrize();
            }
        }
        return promptUserForResultNames(result);
    }

    private static boolean check

    private static boolean existsAMatch(Player player, String name){
        return player.getName().equals(name);
    }

}