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

        while (Input.isNotValidString(nameString)) {
            Output.print("다섯 글자 이하인 이름을 최소 두 개 입력해주세요.");
            nameString = Input.takeString();
        }
        return nameString;
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