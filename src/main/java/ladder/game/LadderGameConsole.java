package ladder.game;

public class LadderGameConsole {
    public static void main(String[] args) {
        startGame();
    }

    private static void test() {
        for (int i = 0; i < 1; i++) {
            System.out.println("hi");
        }
    }

    private static String promptUserForNames() {
        Output.print("참여할 사람 이름을 입력하세요.");
        return Input.takeString();
    }

    private static int promptUserForLadderHeight() {
        Output.print("최대 사다리 높이는 몇 개 인가요?");
        return Input.takeInt();
    }

    private static void startGame() {
        String playerNames = promptUserForNames();
        int ladderHeight = promptUserForLadderHeight();
        LadderGame ladderGame = new LadderGame(playerNames, ladderHeight);

        String ladderString = ladderGame.buildLadder();
        ladderGame.displayLadder(ladderString);
    }
}