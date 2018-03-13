package ladder.domain;

import ladder.view.Input;
import ladder.view.Output;

public class LadderGameConsole {
    public static void main(String[] args) {
        startGame();
    }

    private static String promptUserForNames() {
        Output.print("참여할 사람 이름을 쉼표(,)를 기준으로 입력하세요.");
        String nameString = Input.takeString();

        while (isNotValidString(nameString)) {
            Output.print("최소 두 이름을 입력해주세요.");
            nameString = Input.takeString();
        }
        return nameString;
    }

    private static boolean isNotValidString(String nameString) {
        final int MAX_NUMBER_OF_CHAR = 5;
        String[] names = nameString.split(",");
        return isNotEnoughNames(names);

        for(String name : names){
            if(name.length() > MAX_NUMBER_OF_CHAR){
                return true;
            }
        }
        return false;
    }

    private static boolean isNotEnoughNames(String[] names){
        final int MIN_NUMBER_OF_NAMES = 2;
        if(names.length < MIN_NUMBER_OF_NAMES){
            return true;
        }
        return false;
    }

    private static int promptUserForLadderHeight() {
        final int MIN_HEIGHT = 2;

        Output.print("최대 사다리 높이는 몇 개 인가요?");
        int userInput = Input.takeInt();
        while (userInput <= MIN_HEIGHT) {
            Output.print("2 보다 큰 숫자를 입력해주세요.");
            userInput = Input.takeInt();
        }
        return userInput;
    }

    private static void startGame() {
        String playerNames = promptUserForNames();
        int ladderHeight = promptUserForLadderHeight();
        LadderGame ladderGame = new LadderGame(playerNames, ladderHeight);

        String ladderString = ladderGame.buildLadder();
        ladderGame.displayLadder(ladderString);
    }
}